package PaooGame.GameWindow;

import PaooGame.RefLinks;

import javax.swing.*;
import java.awt.*;

/*! \class GameWindow
    \brief Implementeaza notiunea de fereastra a jocului.

    Membrul wndFrame este un obiect de tip JFrame care va avea utilitatea unei
    ferestre grafice si totodata si cea a unui container (toate elementele
    grafice vor fi continute de fereastra).
 */
public class GameWindow
{
    private JFrame  wndFrame;       /*!< fereastra principala a jocului*/
    private String  wndTitle;       /*!< titlul ferestrei*/
    private int     wndWidth;       /*!< latimea ferestrei in pixeli*/
    private int     wndHeight;      /*!< inaltimea ferestrei in pixeli*/

    private Canvas  canvas;         /*!< "panza/tablou" in care se poate desena*/
    private RefLinks refLinks;

    /*! \fn GameWindow(String title, int width, int height)
            \brief Constructorul cu parametri al clasei GameWindow

            Retine proprietatile ferestrei proprietatile (titlu, latime, inaltime)
            in variabilele membre deoarece vor fi necesare pe parcursul jocului.
            Crearea obiectului va trebui urmata de crearea ferestrei propriuzise
            prin apelul metodei BuildGameWindow()

            \param title Titlul ferestrei.
            \param width Latimea ferestrei in pixeli.
            \param height Inaltimea ferestrei in pixeli.
         */
    public GameWindow(RefLinks GameLinks, String title, int width, int height){
        wndTitle    = title;    /*!< Retine titlul ferestrei.*/
        wndWidth    = width;    /*!< Retine latimea ferestrei.*/
        wndHeight   = height;   /*!< Retine inaltimea ferestrei.*/
        wndFrame    = null;     /*!< Fereastra nu este construita.*/
        this.refLinks =GameLinks;
    }

    /*! \fn private void BuildGameWindow()
        \brief Construieste/creaza fereastra si seteaza toate proprietatile
        necesare: dimensiuni, pozitionare in centrul ecranului, operatia de
        inchidere, invalideaza redimensionarea ferestrei, afiseaza fereastra.

     */
    public void BuildGameWindow()
    {
            /// Daca fereastra a mai fost construita intr-un apel anterior
            /// se renunta la apel
        if(wndFrame != null)
        {
            return;
        }
            /// Aloca memorie pentru obiectul de tip fereastra si seteaza denumirea
            /// ce apare in bara de titlu
        wndFrame = new JFrame(wndTitle);
            /// Seteaza dimensiunile ferestrei in pixeli
        wndFrame.setSize(wndWidth, wndHeight);
        //wndFrame.setUndecorated(true);    // Pentru fullScreen
            /// Operatia de inchidere (fereastra sa poata fi inchisa atunci cand
            /// este apasat butonul x din dreapta sus al ferestrei). Totodata acest
            /// lucru garanteaza ca nu doar fereastra va fi inchisa ci intregul
            /// program
        wndFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            /// Avand in vedere ca dimensiunea ferestrei poate fi modificata
            /// si corespunzator continutul actualizat (aici ma refer la dalele
            /// randate) va recomand sa constrangeti deocamdata jucatorul
            /// sa se joace in fereastra stabilitata de voi. Puteti reveni asupra
            /// urmatorului apel ulterior.
        wndFrame.setResizable(false);
            /// Recomand ca fereastra sa apara in centrul ecranului. Pentru orice
            /// alte pozitie se va apela "wndFrame.setLocation(x, y)" etc.
        wndFrame.setLocationRelativeTo(null);
            /// Implicit o fereastra cand este creata nu este vizibila motiv pentru
            /// care trebuie setata aceasta proprietate

        //wndFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //wndFrame.setUndecorated(true);
        wndFrame.setVisible(true);

        wndFrame.addKeyListener(refLinks.getKeyInput());
        //wndFrame.addMouseListener(GameLinks.getMouseInput());

            /// Creaza obiectul de tip canvas (panza) pe care se poate desena.
        canvas = new Canvas();
            /// In aceeasi maniera trebuiesc setate proprietatile pentru acest obiect
            /// canvas (panza): dimensiuni preferabile, minime, maxime etc.
            /// Urmotorul apel de functie seteaza dimensiunea "preferata"/implicita
            /// a obiectului de tip canvas.
            /// Functia primeste ca parametru un obiect de tip Dimension ca incapsuleaza
            /// doua proprietati: latime si inaltime. Cum acest obiect nu exista
            /// a fost creat unul si dat ca parametru.
        canvas.setPreferredSize(new Dimension(wndWidth, wndHeight));
            /// Avand in vedere ca elementele unei ferestre pot fi scalate atunci cand
            /// fereastra este redimensionata
        canvas.setMaximumSize(new Dimension(wndWidth, wndHeight));
        canvas.setMinimumSize(new Dimension(wndWidth, wndHeight));
            /// Avand in vedere ca obiectul de tip canvas, proaspat creat, nu este automat
            /// adaugat in fereastra trebuie apelata metoda add a obiectul wndFrame
        canvas.addMouseListener(refLinks.getMouseInput());
        wndFrame.add(canvas);
            /// Urmatorul apel de functie are ca scop eventuala redimensionare a ferestrei
            /// ca tot ce contine sa poate fi afisat complet
        wndFrame.pack();
    }

    /*! \fn public int GetWndWidth()
        \brief Returneaza latimea ferestrei.
     */
    public int getWndWidth()
    {
        return wndWidth;
    }

    /*! \fn public int GetWndWidth()
        \brief Returneaza inaltimea ferestrei.
     */
    public int getWndHeight()
    {
        return wndHeight;
    }

    public String getWndTitle()
    {
        return wndTitle;
    }

    /*! \fn public int GetCanvas()
        \brief Returneaza referinta catre canvas-ul din fereastra pe care se poate desena.
     */
    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getWndFrame() { return wndFrame; }
}
