package griffio.components;

import org.springframework.context.annotation.Scope;

import javax.inject.Named;

@Named
@Scope("prototype")
public class InstanceProviderComponent {

    public InstanceProviderComponent() {
    }

}
