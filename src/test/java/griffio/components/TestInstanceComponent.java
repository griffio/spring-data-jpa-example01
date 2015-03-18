package griffio.components;

import com.google.common.truth.Truth;
import griffio.config.ApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.inject.Provider;

@ContextConfiguration(classes = ApplicationConfiguration.class)
public class TestInstanceComponent extends AbstractTestNGSpringContextTests {

    @Inject
    private Provider<InstanceProviderComponent> provider;

    @Test
    public void instanceComponent() {
        Truth.ASSERT.that(provider.get() != provider.get());
    }

}
