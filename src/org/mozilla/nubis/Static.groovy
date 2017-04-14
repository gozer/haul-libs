package org.mozilla.nubis;

def prepSite() {
  sh "mkdir -p dst"
}

def buildSite() {
  sh "rsync -a --delete --cvs-exclude src/ dst/"
}

def syncSite(args="--delete --acl public-read --only-show-errors") {
  //sh "rclone -q sync ${excludes} dst/ s3:${env.SITE_BUCKET}/${env.JOB_BASE_NAME}/"
  //sh "rclone -q sync ${excludes} dst/ s3:${env.SITE_BUCKET}/"
  sh "aws s3 sync ${args} dst/ s3:${env.SITE_BUCKET}/"
}
