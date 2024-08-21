package com.factweavers.authenticationservice.domain.workspace;

import java.time.LocalDateTime;

public interface Sales {
    String getSellPrice();
    LocalDateTime getSoldDate();
    String getSoldPercent();
}
