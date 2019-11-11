function Connection(){
    this.URL_SERVER_BASEURL = "http://localhost:8081/GDPR";

    this.getServerBaseURL = function(){
        return this.URL_SERVER_BASEURL;
    }
}