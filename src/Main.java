import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static AtomicInteger len3 = new AtomicInteger();
    public static AtomicInteger len4 = new AtomicInteger();
    public static AtomicInteger len5 = new AtomicInteger();

    public static void main(String[] args) {

        Hashtable nickname = new Hashtable();

        Random random = new Random();
        String[] texts = new String[100];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        new Thread(() -> {
            for (int i = 0; i < texts.length; i++) {
                switch (texts[i].length()) {
                    case 3:
                        if(texts[i].charAt(0) == texts[i].charAt(2)){
                            if(!nickname.containsKey((texts[i]))) {
                                len3.getAndIncrement();
                                nickname.put(texts[i], texts[i].length());
                                System.out.println(texts[i]);
                            }
                        }
                        break;
                    case 4:
                        if(texts[i].charAt(0) == texts[i].charAt(3) & texts[i].charAt(1) == texts[i].charAt(2) ) {
                            if(!nickname.containsKey((texts[i]))) {
                                len4.getAndIncrement();
                                nickname.put(texts[i], texts[i].length());
                                System.out.println(texts[i]);
                            }
                        }
                        break;
                    case 5:
                        if(texts[i].charAt(0) == texts[i].charAt(4) & texts[i].charAt(1) == texts[i].charAt(3) ) {
                            if(!nickname.containsKey((texts[i]))) {
                            len5.getAndIncrement();
                            nickname.put(texts[i], texts[i].length());
                            System.out.println(texts[i]);
                        }
                        }
                        break;
                }

            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < texts.length; i++) {
                switch (texts[i].length()) {
                    case 3:
                        if(texts[i].charAt(0) == texts[i].charAt(1) && texts[i].charAt(0) == texts[i].charAt(2)) {
                            if(!nickname.containsKey((texts[i]))) {
                                len3.getAndIncrement();
                                nickname.put(texts[i], texts[i].length());
                                System.out.println(texts[i]);
                            }
                        }
                        break;
                    case 4:
                        if(texts[i].charAt(0) == texts[i].charAt(1) && texts[i].charAt(0) == texts[i].charAt(2) && texts[i].charAt(0) == texts[i].charAt(3)) {
                            if(!nickname.containsKey((texts[i]))) {
                                len4.getAndIncrement();
                                nickname.put(texts[i], texts[i].length());
                                System.out.println(texts[i]);
                            }
                        }
                        break;
                    case 5:
                        if(texts[i].charAt(0) == texts[i].charAt(1) && texts[i].charAt(0) == texts[i].charAt(2) && texts[i].charAt(0) == texts[i].charAt(3) && texts[i].charAt(0) == texts[i].charAt(4)) {
                            if(!nickname.containsKey((texts[i]))) {
                                len5.getAndIncrement();
                                nickname.put(texts[i], texts[i].length());
                                System.out.println(texts[i]);
                            }
                        }
                        break;
                }

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < texts.length; i++) {

                int c1 = Character.codePointAt(texts[i], 0);
                int c2 = Character.codePointAt(texts[i], 1);
                int c3 = Character.codePointAt(texts[i], 2);

                switch (texts[i].length()) {
                    case 3:
                        if((c1 == c2 || c2 == (c1 + 1)) && (c2 == c3 || c3 == (c2 + 1))) {
                            if(!nickname.containsKey((texts[i]))) {
                                len3.getAndIncrement();
                                nickname.put(texts[i], texts[i].length());
                                // System.out.println(Character.codePointAt(texts[i], 0) + " " + texts[i]);
                                System.out.println(texts[i]);
                            }
                        }
                        break;
                    case 4:
                        int c4 = Character.codePointAt(texts[i], 3);
                        if((c1 == c2 || c2 == (c1 + 1)) && (c2 == c3 || c3 == (c2 + 1)) && (c3 == c4 || c4 == (c3 + 1))) {
                            if(!nickname.containsKey((texts[i]))) {
                                len4.getAndIncrement();
                                nickname.put(texts[i], texts[i].length());
                                System.out.println(texts[i]);
                            }
                        }
                        break;
                    case 5:
                        c4 = Character.codePointAt(texts[i], 3);
                        int c5 = Character.codePointAt(texts[i], 4);
                        if((c1 == c2 || c2 == (c1 + 1)) && (c2 == c3 || c3 == (c2 + 1)) && (c3 == c4 || c4 == (c3 + 1)) && (c4 == c5 || c5 == (c4 + 1))) {
                            if(!nickname.containsKey((texts[i]))) {
                                len5.getAndIncrement();
                                nickname.put(texts[i], texts[i].length());
                                System.out.println(texts[i]);
                            }
                        }
                        break;
                }

            }
        }).start();


        System.out.println("Красивых слов с длиной 3: " + len3 + " шт");
        System.out.println("Красивых слов с длиной 4: " + len4 + " шт");
        System.out.println("Красивых слов с длиной 5: " + len5 + " шт");

    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

}