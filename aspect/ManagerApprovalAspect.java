package org.example.ex3.aspect;
import org.example.ex3.annotation.RequireManagerApproval;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ManagerApprovalAspect {

    private final HttpServletRequest request;

    @Before("@annotation(requireManagerApproval)")
    public void validateManagerRole(
            RequireManagerApproval requireManagerApproval
    ) {

        String role =
                request.getHeader("X-Role");

        if (!"MANAGER".equals(role)) {

            throw new RuntimeException(
                    "Bạn không có quyền hoàn tiền"
            );

        }

    }

}