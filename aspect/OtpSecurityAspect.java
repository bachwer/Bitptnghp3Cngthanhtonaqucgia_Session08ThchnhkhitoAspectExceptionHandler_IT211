package org.example.ex3.aspect;
import org.example.ex3.annotation.RequireOtp;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class OtpSecurityAspect {

    private final HttpServletRequest request;

    @Before("@annotation(requireOtp)")
    public void validateOtp(
            RequireOtp requireOtp
    ) {

        String otp =
                request.getHeader("X-OTP");

        if (!"123456".equals(otp)) {

            throw new RuntimeException(
                    "OTP không hợp lệ"
            );

        }

    }

}