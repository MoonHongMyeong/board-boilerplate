package me.moon.boilerplate.member.persistence.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.member.exception.PasswordFailedExceededException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String value;

    @NotEmpty
    @Column(name = "password_failed_count", nullable = false)
    private int failedCount;

    @Builder
    public Password(String value){
        this.value = encodePassword(value);
    }

    public void changePassword(String newPassword, String oldPassword){
        if(isMatched(oldPassword)){
            this.value = encodePassword(newPassword);
        }
    }

    public boolean isMatched(String rawPassword){
        if(failedCount >= 5){
            throw new PasswordFailedExceededException();
        }

        boolean matches = isMatches(rawPassword);
        updateFailedCount(matches);
        return matches;
    }

    private void updateFailedCount(boolean matches) {
        if (matches) {
            resetFailedCount();
        }else{
            increaseFailCount();
        }
    }

    private void increaseFailCount() {
        this.failedCount += 1;
    }

    private void resetFailedCount() {
        this.failedCount = 0;
    }

    private boolean isMatches(String rawPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, this.value);
    }

    private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
