package org.mozilla.nubis;

def prepSite() {
  sh "mkdir -p dst"
}

def buildSite() {
  sh "rsync -a --delete --cvs-exclude src/ dst/"
}

def syncSite(excludes="--delete-after --exclude .git/** --exclude .svn/** --delete-excluded") {
  //sh "rclone -q sync ${excludes} dst/ s3:${env.SITE_BUCKET}/${env.JOB_BASE_NAME}/"
  sh "rclone -q sync ${excludes} dst/ s3:${env.SITE_BUCKET}/"
}
