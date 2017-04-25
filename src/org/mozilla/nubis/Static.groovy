package org.mozilla.nubis;

def prepSite() {
  sh "env"
  sh "mkdir -p dst"
}

def buildSite() {
  sh "rsync -a --delete --cvs-exclude src/ dst/"
}

def syncSite(args="--acl public-read --delete") {
//  sh "aws --region \"\$(nubis-region)\" s3 sync ${args} dst/ s3://${env.SITE_BUCKET}/"
  sh "rsync -a --delete dst/ /data/haul/${env.JOB_NAME}/"
}
