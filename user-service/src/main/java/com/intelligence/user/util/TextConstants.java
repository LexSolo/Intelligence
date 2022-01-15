package com.intelligence.user.util;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TextConstants {

  private final MessageSource messageSource;

  public String getTextMessage(String key, Object... params) {
    return messageSource.getMessage(key, params, Locale.getDefault());
  }

  public static final String USER_NOT_FOUND_BY_ID = "user.not-found.id";
  public static final String USER_NOT_FOUND_BY_NAME = "user.not-found.name";
}
