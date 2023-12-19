package ru.mipt.bit.platformer.IO;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.objects.Level;
import ru.mipt.bit.platformer.objects.Tank;
import ru.mipt.bit.platformer.objects.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileLevelLoader implements LevelLoader{

    private final String filepath;

    public FileLevelLoader(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public Level loadLevel() {
        Level level = new Level();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream(filepath)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String strLine;

            int y = 0;
            while ((strLine = br.readLine()) != null) {
                int len = strLine.length();
                for (int x = 0; x < len ; x++) {
                    if (strLine.charAt(x) == 'T') {
                        level.addObject(new Tree(new GridPoint2(x, y)));
                    } else if (strLine.charAt(x) == 'X') {
                        level.addObject(new Tank(0, new GridPoint2(x, y)));
                    }
                }
                y++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return level;
    }
}
