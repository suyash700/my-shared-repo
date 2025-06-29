def call(String app_name){
  sh "docker build --no-cache -t ${app_name}:latest ."
}
