package com.example.Spring_Programowanie_Aspektowe.config;

import com.example.Spring_Programowanie_Aspektowe.api.IKucharz;
import com.example.Spring_Programowanie_Aspektowe.api.InterfejsZapiekanka;
import com.example.Spring_Programowanie_Aspektowe.aspects.AspektZapiekanka;
import com.example.Spring_Programowanie_Aspektowe.aspects.Komunikacja;
import com.example.Spring_Programowanie_Aspektowe.aspects.KontrolaMagazynu;
import com.example.Spring_Programowanie_Aspektowe.implementations.ImplZapiekanka;
import com.example.Spring_Programowanie_Aspektowe.implementations.Kucharz;
import com.example.Spring_Programowanie_Aspektowe.implementations.PomocnikKucharza;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public InterfejsZapiekanka interfejsZapiekanka() {
        return  new ImplZapiekanka();
    }

    @Bean
    public AspektZapiekanka aspektZapiekanka() {
        return new AspektZapiekanka();
    }

    @Bean
    @Qualifier("kucharz")
    public IKucharz kucharz() {
        return new Kucharz();
    }

    @Bean
    @Qualifier("pomocnik_kucharza")
    public IKucharz pomocnikKucharza() {
        return new PomocnikKucharza();
    }

    @Bean
    public Komunikacja komunikacja() {
        return new Komunikacja();
    }

    @Bean
    public KontrolaMagazynu kontrolaMagazynu() {
        return new KontrolaMagazynu();
    }
}
