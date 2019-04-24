#!/usr/bin/env bash

set -euo pipefail

usage()
{
    cat <<END
pack-images.sh: 对docker镜像进行打包
Parameters:
  -r | --registry <container registry> 
    指明docker私有镜像仓库
  -t | --tag <docker image tag> 
    docker 镜像的标签
  --skip-build
    构建镜像之前是否需要编译代码
  -p | --docker-project
     项目名称
  --skip-image-push
    是否需要推送镜像
  --clear-images
    是否清理打包后本地的镜像
  -h | --help
    显示帮助
END
}

image_tag=$(date '+%Y%m%d%H%M')
skip_build=''
container_registry=''
build_images='yes'
push_images='yes'
docker_project='hlservice'
clear_images=''

workdir=$(cd $(dirname $0); pwd)

while [[ $# -gt 0 ]]; do
  case "$1" in
    -r | --registry )
        container_registry="$2"; shift 2 ;;
    -t | --image-tag )
        image_tag="$2"
        shift 2 ;;
    --skip-build )
        skip_build='yes'; shift 2;;
    -p | --docker-project )
       docker_project="$2"; shift 2;;
    --skip-image-push )
        push_images=''; shift 2;;
    --clear-images )
       clear_images='yes'; shift 2;;
    -h | --help )
        usage; exit 1 ;;

    *)
        echo "Unknown option $1"
        usage; exit 2 ;;
  esac
done

if [[ !"${skip_build}" ]]; then
echo "#################### Building HlAdmin Package ####################"
mvn clean package "-Dmaven.test.skip=true"
fi

echo "指定docker镜像的tag为${image_tag}"
export TAG=$image_tag
echo "#################### Building HlAdmin Docker images ####################"
docker-compose -p .. -f ${workdir}/../docker-compose/hl-admin/docker-compose.yml build

if [ $? -ne 0 ]; then
    echo "构建镜像失败,请稍后重试..."
    exit 3
fi

f [[ $push_images ]]; then
    echo "#################### Pushing images to registry ####################"
    image_fqdn=""
    if [[ "${docker_project:-}" ]]; then
      image_fqdn="${docker_project}"
    fi
    if [[ "${container_registry:-}" ]]; then
      image_fqdn="${container_registry}/${image_fqdn}"
    fi
    services=(`cat ${workdir}/ServiceComponents`)
    for service in "${services[@]}"
    do
      image_repo=$service
      if [[ "${image_fqdn:-}" ]]; then
         image_repo="${image_fqdn}/${image_repo}"
      fi
      echo "推送${image_repo}:${image_tag} docker镜像到镜像仓库.."
      docker tag "hladmin/${service}:${image_tag}" "${image_repo}:${image_tag}"
      docker push "${image_repo}:${image_tag}"
    done
fi

if [[ $clear_images ]]; then
  echo "#################### clear local images ####################"
  docker rmi -f $(docker images|grep $image_tag|awk '{print $3}')
fi

# Remove temporary images
docker rmi -f $(docker images -qf "dangling=true")     

if [ $? -ne 0 ]; then
    echo "删除所有未使用镜像和悬空的镜像失败..."
    exit 3
fi