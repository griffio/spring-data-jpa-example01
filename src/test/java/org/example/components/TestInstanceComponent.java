package org.example.components;

import org.hamcrest.core.IsNot;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.inject.Provider;

import static org.hamcrest.MatcherAssert.assertThat;

@ContextConfiguration
public class TestInstanceComponent extends AbstractTestNGSpringContextTests {

    @Inject
    private Provider<InstanceProviderComponent> provider;

    @Test
    public void instanceComponent() {
        assertThat(provider.get(), IsNot.not(provider.get()));
    }

}
