package matrix.tool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test void testMatrixConstructor1() {
       Matrix m = new Matrix(3,3);
       assertEquals(m.getNumColumns(),3);
       assertEquals(m.getNumRows(),3);
    }
    
}