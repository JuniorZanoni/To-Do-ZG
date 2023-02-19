package utils

import java.time.LocalTime

class ConvertStringInLocalTime {
    LocalTime convert(String time) {
        return LocalTime.parse(time)
    }
}
