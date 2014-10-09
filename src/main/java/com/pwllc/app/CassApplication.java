package com.pwllc.app;

import com.pwllc.model.AstCQLClient;
import com.pwllc.rest.CassResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 *
 * @author carl_downs
 */
public class CassApplication extends Application<CassConfiguration> {

    private AstCQLClient astDAO;

    /**
     * Entry point for the application.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new CassApplication().run(args);
    }

    @Override
    public String getName() {
        return "cassandra";
    }

    /**
     *
     */
    @Override
    public void initialize(Bootstrap<CassConfiguration> bootstrap) {
        // nothing to do yet
        //bootstrap.addBundle(bundle);
        //bootstrap.addCommand(command);
        astDAO = new AstCQLClient();
        astDAO.init();
    }

    /**
     *
     */
    @Override
    public void run(CassConfiguration config, Environment env)
            throws ClassNotFoundException {

        initResources(config, env);
        initHealthChecks(config, env);
    }

    /**
     * @param config
     * @param env
     * @throws ClassNotFoundException
     */
    private void initResources(CassConfiguration config, Environment env)
            throws ClassNotFoundException {
        env.jersey().register(new CassResource(astDAO));
    }

    /**
     * @param config
     * @param env
     */
    private void initHealthChecks(CassConfiguration config, Environment env) {
        final CassHealth check = new CassHealth(
                config.getTemplate());

        env.healthChecks().register("template", check);
    }

}