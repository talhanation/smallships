import com.talhanation.smallships.client.model.ModelBrigg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ModelBriggTest {

    private ModelBrigg modelBrigg;

    @BeforeEach
    public void setUp() {
        modelBrigg = Mockito.mock(ModelBrigg.class);
    }

    @Test
    public void testCreateBodyLayer() {
        // Verify that the static method 'createBodyLayer' returns a non-null object
        LayerDefinition layerDefinition = ModelBrigg.createBodyLayer();
        assertNotNull(layerDefinition);
    }
}
