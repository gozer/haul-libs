package org.mozilla.nubis;

def prepSite() {
  sh "mkdir -p dst"
}

def buildSite() {
  sh "rsync -a --delete --cvs-exclude src/ dst/"
}

def syncSite(args="--acl public-read --delete") {
  sh "env"
  sh "aws --debug --region \"\$(nubis-region)\" s3 sync ${args} dst/ s3://${env.SITE_BUCKET}/"
}
