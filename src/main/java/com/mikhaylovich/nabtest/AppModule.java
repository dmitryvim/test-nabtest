package com.mikhaylovich.nabtest;


import ru.hh.nab.NabModule;

public class AppModule extends NabModule {

  @Override
  protected void configureApp() {
      bindJerseyResources(ATSResource.class);
      // если вы делаете inject используя interface, то надо указать, какую именно имплементацию injectить
      bind(InterfaceService1.class).to(Service1.class);
  }
}
