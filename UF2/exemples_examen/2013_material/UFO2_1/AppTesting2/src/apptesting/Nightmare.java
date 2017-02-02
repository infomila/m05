package apptesting;

class Nightmare {
    
    public void testMeIfYouDare(int i, int f, Object d) {
        int k = 0;
        if (d == null) {
            return;
        }
        while (i >= 0 && f > 2) {
            if (i == 10) {
                i = 20;
                if (d instanceof String || f > 20) {
                    System.out.println("What are you doing here?");
                }
            } else {
                switch (f) {
                    case 2:
                        k++;
                        break;
                    case 3:
                        k--;
                        break;
                    case 5:
                        throw new RuntimeException();
                    default:
                        k *= 2;
                }
                i--;
            }
            k++;
            f = f / 2;
        }
        if (f == i) {
            System.out.println("Surprise surprise!");
        }
        System.out.println("Valors: k="+k+", f="+f+", i="+i);
    }
}