#!/bin/bash

jelastic_api_url='app.jpc.infomaniak.com'

docker_image='tutum/wordpress'
docker_tag='latest'

env_name='testenv-'$(((RANDOM % 10000) + 1))

WORK_DIR=$(dirname $0)
LOG="$WORK_DIR/$hoster_api_url.log"

log() {
	echo "logs ok stage deploy"
    echo -e "\n$@" >>"$LOG"
}

login() {

    SESSION=$(curl -s "https://$jelastic_api_url/1.0/users/authentication/rest/signin?login=$JELASTIC_USR&password=$JELASTIC_PASS" | \
        sed -E 's/^.*"session":"([^"]+)".*$/\1/')
    [ -n "$SESSION" ] || {
        log "Failed to login with credentials supplied"
        exit 0
    }
}

deploy_stage() {
    echo "=============================== START CREATING $env_name | $(date +%d.%m.%y_%H-%M-%S) ==============================="

        

        curl -s "https://$jelastic_api_url/1.0/environment/deployment/rest/builddeployproject?delay=1&envName=maven&session=35ex0e8baeaa2b22267d23a10d9657f2773e&nodeid=4280&projectid=boutique-service-stage&isSequential=false" >> "$LOG"

    echo "=============================== STOP CREATING $env_name | $(date +%d.%m.%y_%H-%M-%S) ==============================="
}


login
deploy_stage
echo "sleeping 10 second to deploy" 
sleep 10