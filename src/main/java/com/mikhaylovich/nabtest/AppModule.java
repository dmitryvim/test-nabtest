package com.mikhaylovich.nabtest;


import ru.hh.nab.NabModule;

public class AppModule extends NabModule {

  @Override
  protected void configureApp() {
    bindJerseyResources(ATSResource.class);
  }
}
