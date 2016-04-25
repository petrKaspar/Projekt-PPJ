package ppj.assignments.configs;

import com.sun.org.glassfish.external.probe.provider.annotations.Probe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ppj.assignments.writer.ProdWriter;
import ppj.assignments.writer.Writer;

/**
 * Created by Petr on 04.04.2016.
 */
@Configuration
public class WriterConfiguration {
    //podle aktivniho profilu se v mainu vzbere spravnz writer
    @Profile("prod")
    @Bean
    public Writer defaultWriter(){return new ProdWriter();}
    // je jedno, jak se to jmenuje

    @Profile("devel")
    @Bean
    public Writer debugtWriter(){return new ProdWriter();}


}
