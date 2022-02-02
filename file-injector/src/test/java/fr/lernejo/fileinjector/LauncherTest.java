package fr.lernejo.fileinjector;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class LauncherTest {

    @Test
    void main_terminates_before_5_sec() {
        assertTimeoutPreemptively(
            Duration.ofSeconds(5L),
            () -> Launcher.main(new String[]{}));
    }

    @Test
    void inject_json() throws IOException {
        Launcher.main(new String[]{"src/test/resources/games.json"});
    }

    @Test
    void inject_wrong_json() throws IOException {
        Launcher.main(new String[]{"src/test/resources/fake.json"});
    }

    @Test
    void inject_no_json() throws IOException {
        Launcher.main(new String[]{});
    }
}
