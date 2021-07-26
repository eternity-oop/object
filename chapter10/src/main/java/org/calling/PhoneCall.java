package org.calling;

import java.time.Duration;
import java.time.LocalDateTime;

public class PhoneCall {
        private LocalDateTime from;
        private LocalDateTime to;

        public PhoneCall(LocalDateTime from, LocalDateTime to) {
            this.from = from;
            this.to = to;
        }

        public Duration getDuration() {
            return Duration.between(from, to);
        }

        public LocalDateTime getFrom() {
            return from;
        }
    }
