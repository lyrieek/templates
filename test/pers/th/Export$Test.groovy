package pers.th

import org.junit.Test
import org.junit.Before
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

/**
 * Created by Tianhao on 2018-07-09.
 */
class Export$Test {
    @Mock
    Export$ MODULE$
    @InjectMocks
    Export$ export$

    @Before
    void setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    void testMain() {
        export$.main(["args"] as String[])
    }

    @Test
    void testOutput() {
        File result = export$.output()
        assert result == new File(getClass().getResource("/pers/th/PleaseReplaceMeWithTestFile.txt").getFile())
    }

    @Test
    void testParam() {
        Parameter result = export$.param()
        assert result == new Parameter()
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme