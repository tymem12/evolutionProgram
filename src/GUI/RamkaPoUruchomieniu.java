package GUI;

import Narzedzia.Losowe;
import PakietOrganizacyjny.ProjektGeneracja;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class RamkaPoUruchomieniu extends javax.swing.JFrame {
    ProjektGeneracja PG;
    private int numerGen =0;
    private int indeksWarunku;
    private int indeksBariery;
    private boolean czyPlikZaladowany;
   // private boolean czyTrzebaZapiszJako;
    private boolean czyMoznaUruchomic;


    public RamkaPoUruchomieniu() {
        czyPlikZaladowany = false;

        PG = new ProjektGeneracja();
        PG.setCzyPlikZapisany(false);
        initComponents();
    }
    private void initComponents() {

        MojPanel_Srodowisko = new Panel_Srodowisko();
        PG.setPanelek((Panel_Srodowisko) MojPanel_Srodowisko);

        Label_Populacja = new javax.swing.JLabel();
        Label_NGeneracja = new javax.swing.JLabel();
        Button_NowaGeneracja = new javax.swing.JButton();
        ComboBox_WarunekZycia = new javax.swing.JComboBox<>();
        Button_UruchomSymulacje = new javax.swing.JButton();
        ComboBox_Bariery = new javax.swing.JComboBox<>();
        Label_WielkoscGenomu = new javax.swing.JLabel();
        Label_AktualnaGeneracja = new javax.swing.JLabel();
        Label_Procent = new javax.swing.JLabel();
        Button_PrzygotujSym = new javax.swing.JButton();
        Label_LiczbaNeuronow = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu_Plik = new javax.swing.JMenu();
        MenuItem_Otworz = new javax.swing.JMenuItem();
        jMenuItem_Zapisz = new javax.swing.JMenuItem();
        MenuItem_ZapiszJako = new javax.swing.JMenuItem();
        Menu_Program = new javax.swing.JMenu();
        MenuItem_Zamknij = new javax.swing.JMenuItem();
        MenuItem_Restartuj = new javax.swing.JMenuItem();
        MenuItem_DokonajAnalizy = new javax.swing.JMenuItem();
        MenuItem_Procent = new javax.swing.JMenuItem();
        MenuItem_Nowy = new javax.swing.JMenuItem();
        Menu_Pomoc = new javax.swing.JMenu();
        MenuItem_Instrukcja = new javax.swing.JMenuItem();

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        TextField_NGeneracja = new javax.swing.JFormattedTextField(formatter);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1375, 860));


        MojPanel_Srodowisko.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MojPanel_Srodowisko.setPreferredSize(new java.awt.Dimension(780, 780));
        MojPanel_Srodowisko.setLayout(new java.awt.GridLayout(128, 128));


        Button_NowaGeneracja.setText("NASTĘPNA GENERACJA");
        Button_UruchomSymulacje.setText("URUCHOM SYMULACJE");

        TextField_NGeneracja.setToolTipText("Wpisz numer generacji, którą chcesz przygotować");
        TextField_NGeneracja.setEnabled(false);


        Button_NowaGeneracja.setMinimumSize(new java.awt.Dimension(157, 25));
        Button_NowaGeneracja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_NowaGeneracjaActionPerformed(evt);
            }
        });
        
        ComboBox_WarunekZycia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1. OKRĄG ŚRODKOWY",
                "2. PRAWA POŁOWA", "3. GÓRNA POŁOWA", "4. ROGI ŚRODOWISKA", "5. PRZY ŚCIANIE", "6. BLISKO ŚCIANY", "7. ODSTĘPY" }));


        Button_UruchomSymulacje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_UruchomSymulacjeActionPerformed(evt);
            }
        });

        ComboBox_Bariery.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1. BRAK BARIERY", "2. BARIERA - TYP BRAMA", "3. BARIERA- TYP PRZESZKODA","4. BARIERA - ZABÓJCZA" }));

        Label_NGeneracja.setText("USTAW GENERACJE:");
        Label_Populacja.setText("POPULACJA: ");

        Label_WielkoscGenomu.setText("WIELKOŚĆ GENOMU: ");
        Label_AktualnaGeneracja.setText("AKTUALNA GENERACJA: ");


        Label_Procent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Button_PrzygotujSym.setText("PRZYGOTUJ WYBRANĄ GENERACJĘ");
        Button_PrzygotujSym.setMaximumSize(new java.awt.Dimension(157, 25));
        Button_PrzygotujSym.setMinimumSize(new java.awt.Dimension(157, 25));
        Button_PrzygotujSym.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PrzygotujSymActionPerformed(evt);
            }
        });

        Label_LiczbaNeuronow.setText("LICZBA NEURONÓW WEWNĘTRZNYCH: ");

        jMenuBar1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(74, 30));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(74, 30));

        Menu_Plik.setText("Plik");
        Menu_Plik.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        MenuItem_Otworz.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuItem_Otworz.setText("Otwórz");
        MenuItem_Otworz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_OtworzActionPerformed(evt);
            }
        });
        Menu_Plik.add(MenuItem_Nowy);

        MenuItem_Nowy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuItem_Nowy.setText("Nowy");
        MenuItem_Nowy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_NowyActionPerformed(evt);
            }
        });


        Menu_Plik.add(MenuItem_Otworz);

        jMenuItem_Zapisz.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_Zapisz.setText("Zapisz");
        jMenuItem_Zapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ZapiszActionPerformed(evt);
            }
        });
        Menu_Plik.add(jMenuItem_Zapisz);

        MenuItem_ZapiszJako.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuItem_ZapiszJako.setText("Zapisz jako");
        MenuItem_ZapiszJako.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_ZapiszJakoActionPerformed(evt);
            }
        });
        Menu_Plik.add(MenuItem_ZapiszJako);

        jMenuBar1.add(Menu_Plik);

        Menu_Program.setText("Program");
        Menu_Program.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        MenuItem_Zamknij.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuItem_Zamknij.setText("Zamknij");
        MenuItem_Zamknij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_ZamknijActionPerformed(evt);
            }
        });
        Menu_Program.add(MenuItem_Zamknij);

        MenuItem_Restartuj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuItem_Restartuj.setText("Restartuj");
        MenuItem_Restartuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_RestartujActionPerformed(evt);
            }
        });
        Menu_Program.add(MenuItem_Restartuj);

        MenuItem_DokonajAnalizy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuItem_DokonajAnalizy.setText("Dokonaj Analizy");
        MenuItem_DokonajAnalizy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_DokonajAnalizyActionPerformed(evt);
            }
        });
        Menu_Program.add(MenuItem_DokonajAnalizy);

        MenuItem_Procent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuItem_Procent.setText("Oblicz Procent");
        MenuItem_Procent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_ProcentActionPerformed(evt);
            }
        });
        Menu_Program.add(MenuItem_Procent);

        jMenuBar1.add(Menu_Program);

        Menu_Pomoc.setText("Pomoc");
        Menu_Pomoc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        MenuItem_Instrukcja.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuItem_Instrukcja.setText("Wyświetl Instrukcje");
        Menu_Pomoc.add(MenuItem_Instrukcja);

       // jMenuBar1.add(Menu_Pomoc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(MojPanel_Srodowisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(Button_UruchomSymulacje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Label_Procent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(ComboBox_WarunekZycia, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ComboBox_Bariery, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Label_WielkoscGenomu, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(Label_LiczbaNeuronow, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(Label_AktualnaGeneracja, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(Label_Populacja, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(2, 2, 2)))
                                        .addComponent(Button_NowaGeneracja, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(Label_NGeneracja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(TextField_NGeneracja, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(Button_PrzygotujSym, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(Label_AktualnaGeneracja, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Label_Populacja, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Label_WielkoscGenomu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Label_LiczbaNeuronow, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(140, 140, 140)
                                                .addComponent(ComboBox_WarunekZycia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ComboBox_Bariery, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Label_NGeneracja, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(TextField_NGeneracja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(8, 8, 8)
                                                .addComponent(Button_PrzygotujSym, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Button_NowaGeneracja, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(Button_UruchomSymulacje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(99, 99, 99)
                                                .addComponent(Label_Procent, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(MojPanel_Srodowisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>
    private void Button_UruchomSymulacjeActionPerformed(java.awt.event.ActionEvent evt) {
        if(czyPlikZaladowany){
            PG.RopocznijSymulacje();
           czyMoznaUruchomic = false;
           kontrolujPrzyciski();
        }
        else{
            JOptionPane.showMessageDialog(this, "Należy wczytać lub stworzyć nowy plik", "Brak Załadowanego pliku",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    private void Button_NowaGeneracjaActionPerformed(java.awt.event.ActionEvent evt) {
        if(czyPlikZaladowany){
            PG.getDane().setIndeksBariery(ComboBox_Bariery.getSelectedIndex());
            PG.getDane().setIndeksWarunku(ComboBox_WarunekZycia.getSelectedIndex());
            PG.StworzNowaGeneracje(1);
            czyMoznaUruchomic =true;
            kontrolujPrzyciski();

            numerGen += 1;
            AktualizacjaStałych();


        }else{
            JOptionPane.showMessageDialog(this, "Należy wczytać lub stworzyć nowy plik", "Brak Załadowanego pliku",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void Button_PrzygotujSymActionPerformed(java.awt.event.ActionEvent evt) {


        if(czyPlikZaladowany){
            Przygotowania();

            if(numerGen ==0){
                numerGen +=1;
                AktualizacjaStałych();
                PG.PrzygotujGeneracje();
                czyMoznaUruchomic = true;
                kontrolujPrzyciski();

            } else if(TextField_NGeneracja.getText().equals("") || (((Number)TextField_NGeneracja.getValue()).intValue() <= numerGen)) {
                JOptionPane.showMessageDialog(this, "Nieprawidłowo wprowadzona wartość Gene", "Brak Załadowanego pliku",
                        JOptionPane.WARNING_MESSAGE);
            }

            else if (((Number)TextField_NGeneracja.getValue()).intValue()> numerGen ) {
                int aktualna = numerGen;
                numerGen = ((Number)TextField_NGeneracja.getValue()).intValue();
                PG.StworzNowaGeneracje( numerGen - aktualna);
                PG.getDane().setNumerGeneracji(numerGen);
                AktualizacjaStałych();
               czyMoznaUruchomic = true;
               kontrolujPrzyciski();
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Należy wczytać lub stworzyć nowy plik", "Brak Załadowanego pliku",
                    JOptionPane.WARNING_MESSAGE);
        }
    }


    private void jMenuItem_ZapiszActionPerformed(java.awt.event.ActionEvent evt) {
        if(czyPlikZaladowany){
            PG.setStanSymulacji(czyMoznaUruchomic);
            PG.getDane().setNumerGeneracji(numerGen);
            PG.getDane().setIndeksWarunku(ComboBox_WarunekZycia.getSelectedIndex());
            PG.getDane().setIndeksBariery(ComboBox_Bariery.getSelectedIndex());

            if(!PG.isCzyPlikZapisany()){
                PG.ZapiszPlik();
                this.setTitle(getPG().getNazwaPliku());
                PG.setCzyPlikZapisany(true);
            }else{
                PG.NadpiszPlik();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Należy wczytać lub stworzyć nowy plik", "Brak Załadowanego pliku",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void MenuItem_RestartujActionPerformed(java.awt.event.ActionEvent evt) {
        if (czyPlikZaladowany) {
            PG.Zrestartuj();
            numerGen = 0;
            AktualizacjaStałych();
            Button_PrzygotujSym.setEnabled(true);
            Button_NowaGeneracja.setEnabled(false);
            Button_UruchomSymulacje.setEnabled(false);

        }else{
            JOptionPane.showMessageDialog(this, "Należy wczytać lub stworzyć nowy plik", "Brak Załadowanego pliku",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void MenuItem_DokonajAnalizyActionPerformed(java.awt.event.ActionEvent evt) {
        if (czyPlikZaladowany) {
            PG.getDane().setNumerGeneracji(numerGen);
            PG.getDane().setIndeksWarunku(ComboBox_WarunekZycia.getSelectedIndex());
            PG.getDane().setIndeksBariery(ComboBox_Bariery.getSelectedIndex());
            PG.GenerujPlik();
        }
    }

    private void MenuItem_OtworzActionPerformed(java.awt.event.ActionEvent evt) {
       czyPlikZaladowany = true;
       Label_Procent.setText("");
       PG.WczytajPlik(PG);

        czyMoznaUruchomic = PG.isStanSymulacji();
        kontrolujPrzyciski();
        numerGen = PG.getDane().getNumerGeneracji();

        ComboBox_WarunekZycia.setSelectedIndex(PG.getDane().getIndeksWarunku());
        ComboBox_Bariery.setSelectedIndex(PG.getDane().getIndeksBariery());
        TextField_NGeneracja.setEnabled(true);
        TextField_NGeneracja.setText("");
        AktualizacjaStałych();

        this.setTitle((getPG().getNazwaPliku()));
    }

    private void MenuItem_ZapiszJakoActionPerformed(java.awt.event.ActionEvent evt) {
        PG.setStanSymulacji(czyMoznaUruchomic);
        PG.getDane().setNumerGeneracji(numerGen);
        PG.getDane().setIndeksWarunku(ComboBox_WarunekZycia.getSelectedIndex());
        PG.getDane().setIndeksBariery(ComboBox_Bariery.getSelectedIndex());

        PG.ZapiszPlik();;
        this.setTitle(getPG().getNazwaPliku());

    }

    private void MenuItem_ZamknijActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0); // może z nowym oknem i pytaniem czy bez zapsiania
    }

    private void MenuItem_ProcentActionPerformed(java.awt.event.ActionEvent evt) {
        if(Label_Procent.getText().equals("")) {
            String komunikat;
            double wartosc = PG.ObliczProcent() * 100;

            komunikat = String.format("Przeżyło %.2f", wartosc);
            komunikat = komunikat + "%";
            int Zabitych = PG.getOperator().getLiczbaZabitych();
            if (Zabitych != 0) {

                komunikat = komunikat + "Zabito " + Zabitych;

            }
            Label_Procent.setText(komunikat);
        }else{
            Label_Procent.setText("");
        }
    }
    private void MenuItem_NowyActionPerformed(java.awt.event.ActionEvent evt) {
        new RamkaStartowa(this).setVisible(true);

    }
    public void Przygotowania(){
        TextField_NGeneracja.setEnabled(true);
        indeksWarunku = ComboBox_WarunekZycia.getSelectedIndex();
        indeksBariery = ComboBox_Bariery.getSelectedIndex();
        PG.getDane().setIndeksWarunku(indeksWarunku);
        PG.getDane().setIndeksBariery(indeksBariery);
    }
    public void AktualizacjaStałych(){
        Label_AktualnaGeneracja.setText(Losowe.FormatujTekst("AKTUALNA GENERACJA: ",numerGen));
        Label_Populacja.setText(Losowe.FormatujTekst("POPULACJA: ",PG.getDane().getPopulacja()));
        Label_LiczbaNeuronow.setText(Losowe.FormatujTekst("LICZBA NEURONÓW WEWNĘTRZNYCH: ", PG.getDane().getLiczbaNeuronow())) ;
        Label_WielkoscGenomu.setText(Losowe.FormatujTekst("WIELKOSC GENOMU:  ", PG.getDane().getLiczbaGenow())) ;
    }
    public void kontrolujPrzyciski() {
        if (czyMoznaUruchomic) {
            Button_NowaGeneracja.setEnabled(false);
            Button_UruchomSymulacje.setEnabled(true);
            Button_PrzygotujSym.setEnabled(false);
        }else{
            Button_NowaGeneracja.setEnabled(true);
            Button_UruchomSymulacje.setEnabled(false);
            Button_PrzygotujSym.setEnabled(true);
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton Button_NowaGeneracja;
    private javax.swing.JButton Button_PrzygotujSym;
    private javax.swing.JButton Button_UruchomSymulacje;
    private javax.swing.JComboBox<String> ComboBox_Bariery;
    private javax.swing.JComboBox<String> ComboBox_WarunekZycia;
    private javax.swing.JLabel Label_AktualnaGeneracja;
    private javax.swing.JLabel Label_NGeneracja;
    private javax.swing.JLabel Label_Populacja;
    private javax.swing.JLabel Label_Procent;
    private javax.swing.JLabel Label_WielkoscGenomu;
    private javax.swing.JLabel Label_LiczbaNeuronow;
    private javax.swing.JMenuItem MenuItem_DokonajAnalizy;
    private javax.swing.JMenuItem MenuItem_Instrukcja;
    private javax.swing.JMenuItem MenuItem_Otworz;
    private javax.swing.JMenuItem MenuItem_Procent;
    private javax.swing.JMenuItem MenuItem_Restartuj;
    private javax.swing.JMenuItem MenuItem_Zamknij;
    private javax.swing.JMenuItem MenuItem_ZapiszJako;
    private javax.swing.JMenu Menu_Plik;
    private javax.swing.JMenu Menu_Pomoc;
    private javax.swing.JMenu Menu_Program;
    private javax.swing.JPanel MojPanel_Srodowisko;
   // private javax.swing.JTextField TextField_NGeneracja;
   private javax.swing.JFormattedTextField TextField_NGeneracja;

    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem MenuItem_Nowy;
    private javax.swing.JMenuItem jMenuItem_Zapisz;
    // End of variables declaration


    public ProjektGeneracja getPG() {
        return PG;
    }

    public void setPG(ProjektGeneracja PG) {
        this.PG = PG;
    }

    public int getNumerGen() {
        return numerGen;
    }

    public void setNumerGen(int numerGen) {
        this.numerGen = numerGen;
    }

    public boolean isCzyPlikZaladowany() {
        return czyPlikZaladowany;
    }

    public void setCzyPlikZaladowany(boolean czyPlikZaladowany) {
        this.czyPlikZaladowany = czyPlikZaladowany;
    }

    public boolean isCzyMoznaUruchomic() {
        return czyMoznaUruchomic;
    }

    public void setCzyMoznaUruchomic(boolean czyMoznaUruchomic) {
        this.czyMoznaUruchomic = czyMoznaUruchomic;
    }

    public JButton getButton_NowaGeneracja() {
        return Button_NowaGeneracja;
    }

    public void setButton_NowaGeneracja(JButton button_NowaGeneracja) {
        Button_NowaGeneracja = button_NowaGeneracja;
    }

    public JButton getButton_PrzygotujSym() {
        return Button_PrzygotujSym;
    }

    public void setButton_PrzygotujSym(JButton button_PrzygotujSym) {
        Button_PrzygotujSym = button_PrzygotujSym;
    }

    public JButton getButton_UruchomSymulacje() {
        return Button_UruchomSymulacje;
    }

    public void setButton_UruchomSymulacje(JButton button_UruchomSymulacje) {
        Button_UruchomSymulacje = button_UruchomSymulacje;
    }

    public JLabel getLabel_Procent() {
        return Label_Procent;
    }

    public void setLabel_Procent(JLabel label_Procent) {
        Label_Procent = label_Procent;
    }
}


