package pers.th

import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

class Export$Test {
    @Mock
    Export$ MODULE$
    @InjectMocks
    Export$ export$

    @Test
    void testMain() {
        export$.main(["args"] as String[])
    }

    @Test
    void testOutput() {
        File result = export$.output()
        assert result == null
    }

    @Test
    void testParam() {
        Parameter result = export$.param()
        assert result == new Parameter()
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme