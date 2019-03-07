#!/bin/bash

jelastic_api_url='app.jpc.infomaniak.com'

docker_image='tutum/wordpress'
docker_tag='latest'

env_name='testenv-'$(((RANDOM % 10000) + 1))

WORK_DIR=$(dirname $0)
LOG="$WORK_DIR/$hoster_api_url.log"

log() {
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

create_environment() {
    log "=============================== START CREATING $env_name | $(date +%d.%m.%y_%H-%M-%S) ==============================="

        request='nodes=[{"nodeType":"docker","extip":false,"count":1,"fixedCloudlets":1,"flexibleCloudlets":16,"fakeId":-1,"dockerName":"'$docker_image'","dockerTag":"'$docker_tag'","displayName":"'$docker_image':'$docker_tag'","metadata":{"layer":"cp"}}]&env={"pricingType":"HYBRID","region":"default_region","shortdomain":"'$env_name'"}&actionkey=createenv;'$env_name'&appid='$platform_app_id'&session='$SESSION

        log "$request"

        curl -s "https://$jelastic_api_url/1.0/environment/deployment/rest/builddeployproject?delay=1&envName=maven&session=35ex0e8baeaa2b22267d23a10d9657f2773e&nodeid=4280&projectid=boutique-service_cp_ROOT_103301&isSequential=false" >> "$LOG"

    log "=============================== STOP CREATING $env_name | $(date +%d.%m.%y_%H-%M-%S) ==============================="
}


login
create_environment 