package com.pwllc.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

//import io.dropwizard.db.DataSourceFactory;
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;

public class CassConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Integrated LED Catalog";

//    @Valid
//    @NotNull
//    @JsonProperty
//    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

//    @JsonProperty
//    public DataSourceFactory getDataSourceFactory() {
//        return database;
//    }

}