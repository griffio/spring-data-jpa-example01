package griffio.truth;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import java.math.BigDecimal;

public class CompareSubject extends Subject<CompareSubject, BigDecimal> {

    public static final SubjectFactory<CompareSubject, BigDecimal> create =
            new SubjectFactory<CompareSubject, BigDecimal>() {
                @Override
                public CompareSubject getSubject(FailureStrategy fs, BigDecimal target) {
                    return new CompareSubject(fs, target);
                }
            };

    public CompareSubject(FailureStrategy failureStrategy, BigDecimal subject) {
        super(failureStrategy, subject);
    }

    public void comparesEqualTo(BigDecimal object) {
        if (getSubject().compareTo(object) != 0) {
            fail("matches", object);
        }
    }
}

