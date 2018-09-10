package racetrack

//import grails.util.GrailsUtil

class BootStrap {
  def init = {servletContext -> switch(GrailsUtil.environment){
   // case "development":
   //  def admin = new User(login:"admin", password:"wordpass", role:"admin")
   //  admin.save()
   //  if(admin.hasErrors()){
   //   println admin.errors
   //  }
   //
   //  def jdoe = new User(login:"jdoe",password:"password", role:"user")
   //  jdoe.save()
   //  if(jdoe.hasErrors()){
   //   println jdoe.errors
   //  }

  }

  }

  def destroy = { }

}
