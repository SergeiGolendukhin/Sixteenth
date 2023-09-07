package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Player petya = new Player(1, "Петя", 120);
        Player vasya = new Player(2, "Вася", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);

        int actual = game.round("Петя", "Вася");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player petya = new Player(1, "Петя", 120);
        Player vasya = new Player(2, "Вася", 150);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);

        int actual = game.round("Петя", "Вася");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDraw() {
        Player petya = new Player(1, "Петя", 120);
        Player vasya = new Player(2, "Вася", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);

        int actual = game.round("Петя", "Вася");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player petya = new Player(1, "Петя", 120);
        Player vasya = new Player(2, "Вася", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Вася")
        );

    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player petya = new Player(1, "Петя", 120);
        Player vasya = new Player(2, "Вася", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Петя", "Саша")
        );

    }


}