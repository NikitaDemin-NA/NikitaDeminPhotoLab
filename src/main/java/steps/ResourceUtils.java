package steps;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.runner.DefaultTestRunner;
import com.consol.citrus.dsl.runner.TestRunner;
import org.springframework.core.io.DefaultResourceLoader;

public class ResourceUtils {
    private final TestRunner runner;
    private final DefaultResourceLoader resourceLoader;

    public ResourceUtils(TestRunner runner) {
        this.runner = runner;
        this.resourceLoader = new DefaultResourceLoader();
    }

    private TestContext getTestContext(){
        return ((DefaultTestRunner)this.runner).getTestContext();
    }

}
