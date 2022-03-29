package GUI;

import PakietOrganizacyjny.Dane;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class RamkaStartowa extends javax.swing.JFrame {
    ArrayList<JCheckBox> ListaPrzyciskowSensorow;
    ArrayList<JCheckBox> ListaPrzyciskowAkcji;
    RamkaPoUruchomieniu RS;

    public RamkaStartowa(RamkaPoUruchomieniu ramka) {
        RS = ramka;
        ListaPrzyciskowSensorow = new ArrayList<JCheckBox>();
        ListaPrzyciskowAkcji = new ArrayList<JCheckBox>();
        initComponents();
        setName("Parametry Ewolucji");
        setResizable(false);

    }

    private void initComponents() {
        UIManager.put("ToolTip.font",
                new FontUIResource("Segoe Print", Font.BOLD, 15));

        ListaPrzyciskowSensorow.add(CheckBox_SensorFeromon = new javax.swing.JCheckBox());
        CheckBox_SensorFeromon.setToolTipText("Wysyła sygnał, gdy istota wyczuje Feromon. Dodatkowo istota obiera ten kierunek");
        ListaPrzyciskowSensorow.add(CheckBox_SensorPopHor = new javax.swing.JCheckBox());
        CheckBox_SensorPopHor.setToolTipText("Wysyła sygnał, gdy na Połnoc/Poludnie od istoty znjaduje się 75% populacji");
        ListaPrzyciskowSensorow.add(CheckBox_SensorPopWer = new javax.swing.JCheckBox());
        CheckBox_SensorPopWer.setToolTipText("Wysyła sygnał, gdy na Wschód/Zachód od istoty znjaduje się 75% populacji");
        ListaPrzyciskowSensorow.add(CheckBox_SensorGestPop = new javax.swing.JCheckBox());
        CheckBox_SensorGestPop.setToolTipText("Wysyła sygnał, gdy w dowolnym kierunku znjaduje się 38% populacji");
        ListaPrzyciskowSensorow.add(CheckBox_SensorGranicyNS = new javax.swing.JCheckBox());
        CheckBox_SensorGranicyNS.setToolTipText("Wysyła sygnał, gdy istota ma w swoim zasięgu Połnocną/Poludniową Granicę");
        ListaPrzyciskowSensorow.add(CheckBox_SensorGranicyWE = new javax.swing.JCheckBox());
        CheckBox_SensorGranicyWE.setToolTipText("Wysyła sygnał, gdy istota  ma w swoim zasięgu Wschodnią/Zachodnią Granicę");
        ListaPrzyciskowSensorow.add(CheckBox_SensorNajblizszejBariery = new javax.swing.JCheckBox());
        CheckBox_SensorNajblizszejBariery.setToolTipText("Wysyła sygnał, gdy istota  ma w swoim zasięgu barierę ");
        ListaPrzyciskowSensorow.add(CheckBox_SensorIstoty = new javax.swing.JCheckBox());
        CheckBox_SensorIstoty.setToolTipText("Wysyła sygnał, gdy istota  ma w swoim zasięgu inną istotę");
        ListaPrzyciskowSensorow.add(CheckBox_SensorLokalizacjiNS = new javax.swing.JCheckBox());
        CheckBox_SensorLokalizacjiNS.setToolTipText("Wysyła sygnał, gdy istota jest wysunięta bardzije na Połnoc/Południe");
        ListaPrzyciskowSensorow.add(CheckBox_SensorLokalizacjiWE = new javax.swing.JCheckBox());
        CheckBox_SensorLokalizacjiWE.setToolTipText("Wysyła sygnał, gdy istota jest wysunięta bardzije na Wschód/Zachód");
        ListaPrzyciskowSensorow.add(CheckBox_SensorPrzeszkody = new javax.swing.JCheckBox());
        CheckBox_SensorPrzeszkody.setToolTipText("Wysyła sygnał, gdy pole na które chce się ruszyć istota, jest zajęte");
        ListaPrzyciskowSensorow.add(CheckBox_SensorBezpieczenstwa = new javax.swing.JCheckBox());
        CheckBox_SensorBezpieczenstwa.setToolTipText("Wysyła sygnał, gdy istota znajduje się na niebiezpiecznej przestrzenii");
        ListaPrzyciskowSensorow.add(CheckBox_SensorSrodka = new javax.swing.JCheckBox());
        CheckBox_SensorSrodka.setToolTipText("Wysyła sygnał, gdy istota znajduje się w okolicach środka świata");
        ListaPrzyciskowSensorow.add(CheckBox_SensorKierunkuPopulacji = new javax.swing.JCheckBox());
        CheckBox_SensorKierunkuPopulacji.setToolTipText("Wysyła sygnał, gdy 50% populacji porusza się w tym samym kierunku");

        ListaPrzyciskowAkcji.add(CheckBox_AkcjaRuchS = new javax.swing.JCheckBox());
        CheckBox_AkcjaRuchS.setToolTipText("Istota Porusza się na Poludnie");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaRuchLosowy = new javax.swing.JCheckBox());
        CheckBox_AkcjaRuchLosowy.setToolTipText("Istota Porusza się w losowym kierunku");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaRuchNaprzod = new javax.swing.JCheckBox());
        CheckBox_AkcjaRuchNaprzod.setToolTipText("Istota Porusza się w obranym przez siebie kierunku");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaCel = new javax.swing.JCheckBox());
        CheckBox_AkcjaCel.setToolTipText("Istota wybiera losowy punkt i porusza się w jego kierunku");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaFeromon = new javax.swing.JCheckBox());
        CheckBox_AkcjaFeromon.setToolTipText("Istota wypuszcza w swoim otoczeniu Feromon");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaReaktywnosc = new javax.swing.JCheckBox());
        CheckBox_AkcjaReaktywnosc.setToolTipText("Istota zmienia swoją reaktywność - zmienia efektywność reagowania na czynniki");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaRuchE = new javax.swing.JCheckBox());
        CheckBox_AkcjaRuchE.setToolTipText("Istota Porusza się na Wschód");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaRuchN = new javax.swing.JCheckBox());
        CheckBox_AkcjaRuchN.setToolTipText("Istota Porusza się na Połnoc");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaRuchW = new javax.swing.JCheckBox());
        CheckBox_AkcjaRuchW.setToolTipText("Istota Porusza się na Zachód");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaRuchPrzeciwny = new javax.swing.JCheckBox());
        CheckBox_AkcjaRuchPrzeciwny.setToolTipText("Istota Porusza się w przeciwną stronę do obranego kierunku");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaZasieg = new javax.swing.JCheckBox());
        CheckBox_AkcjaZasieg.setToolTipText("Istota zmienia swój zasięg sensorów");
        ListaPrzyciskowAkcji.add(CheckBox_AkcjaZabojstwo = new javax.swing.JCheckBox());
        CheckBox_AkcjaZabojstwo.setToolTipText("Istota zabija inną istotę która znajduje się na jej lini ruchu");


        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel4 = new javax.swing.JLabel();
        jSpinner_LiczbaNeuronow = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jSpinner_LiczbaCykli = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        Button_ZaznaczDomyslny = new javax.swing.JButton();
        Button_PrzygotujSymulacje = new javax.swing.JButton();
        Button_Restartuj = new javax.swing.JButton();
       ;
        jSpinner_LiczbaPopullacji = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinner_WielkoscGenomu = new javax.swing.JSpinner();


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        CheckBox_SensorFeromon.setText("Sensor Feromonu");

        CheckBox_SensorPopHor.setText("Sensor Gęstości Populacji - Horyzontalnie");

        CheckBox_SensorPopWer.setText("Sensor Gęstości Populacji -Wertykalnie\n");


        CheckBox_SensorGestPop.setText("Sensor Gestości Populacji");


        CheckBox_SensorGranicyNS.setText("Sensor Granicy NS");


        CheckBox_SensorGranicyWE.setText("Sensor Granicy WE");


        CheckBox_SensorNajblizszejBariery.setText("Sensor Najbliżeszej Bariery");


        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("WYBIERZ ODPOWIEDNIE PARAMETRY SYMULACJI");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("SENSORY:");

        CheckBox_SensorIstoty.setText("Sensor Istoty");


        CheckBox_SensorLokalizacjiNS.setText("Sensor Lokalizacji NS");


        CheckBox_SensorLokalizacjiWE.setText("Sensor Lokalizacji WE");


        CheckBox_SensorPrzeszkody.setText("Sensor Przeszkody");


        CheckBox_SensorBezpieczenstwa.setText("Sensor Bezpieczeństwa");


        CheckBox_SensorSrodka.setText("Sensor Środka");


        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("NEURONY AKCJI: ");

        CheckBox_AkcjaRuchS.setText("Akcja Ruch S");


        CheckBox_AkcjaRuchLosowy.setText("Akcja Ruch Losowy");


        CheckBox_AkcjaRuchNaprzod.setText("Akcja Ruch Naprzód");


        CheckBox_AkcjaCel.setText("Akcja Cel");


        CheckBox_AkcjaFeromon.setText("Akcja Emisji Feromonu");

        CheckBox_AkcjaReaktywnosc.setText("Akcja Zmiana Reaktywności");

        CheckBox_AkcjaRuchE.setText("Akcja Ruch E");

        CheckBox_AkcjaRuchN.setText("Akcja Ruch N");


        CheckBox_AkcjaRuchW.setText("Akcja Ruch W");


        CheckBox_AkcjaRuchPrzeciwny.setText("Akcja Ruch W Przeciwnym");

        CheckBox_AkcjaZabojstwo.setText("Akcja Zabójstwo");


        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("POZOSTAŁE WARUNKI:");

        jSpinner_LiczbaNeuronow.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));

        jLabel5.setText("Liczba Neuronów Pośrednich");

        jSpinner_LiczbaCykli.setModel(new javax.swing.SpinnerNumberModel(100, 100, 500, 1));

        jLabel6.setText("Liczba Cykli W Generacji");

        Button_ZaznaczDomyslny.setText("Domyślne Ustawienia");
        Button_ZaznaczDomyslny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ZaznaczDomyslnyActionPerformed(evt);
            }
        });

        Button_PrzygotujSymulacje.setText("Przygotuj Symulacje");
        Button_PrzygotujSymulacje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PrzygotujSymulacjeActionPerformed(evt);
            }
        });

        Button_Restartuj.setText("Wyczyść Ustawienia");
        Button_Restartuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RestartujActionPerformed(evt);
            }
        });


        CheckBox_SensorKierunkuPopulacji.setText("Sensor Kierunku Populacji");


        jSpinner_LiczbaPopullacji.setModel(new javax.swing.SpinnerNumberModel(2, 0, 3000, 1));

        jLabel7.setText("Wielkość Genomu");

        jLabel8.setText("Wielkość Populacji");

        jSpinner_WielkoscGenomu.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));

        CheckBox_AkcjaZasieg.setText("Akcja Zasięg");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(16, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(CheckBox_SensorFeromon)
                                                        .addComponent(CheckBox_SensorPopHor)
                                                        .addComponent(CheckBox_SensorGranicyWE, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CheckBox_SensorNajblizszejBariery, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CheckBox_SensorIstoty, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CheckBox_SensorPrzeszkody, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CheckBox_SensorSrodka, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CheckBox_SensorLokalizacjiWE, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CheckBox_SensorLokalizacjiNS, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CheckBox_SensorBezpieczenstwa, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CheckBox_SensorKierunkuPopulacji, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CheckBox_SensorPopWer)
                                                        .addComponent(CheckBox_SensorGestPop)
                                                        .addComponent(CheckBox_SensorGranicyNS))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CheckBox_AkcjaRuchLosowy, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(CheckBox_AkcjaRuchW, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CheckBox_AkcjaRuchS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CheckBox_AkcjaRuchN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CheckBox_AkcjaCel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CheckBox_AkcjaFeromon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CheckBox_AkcjaReaktywnosc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CheckBox_AkcjaRuchE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(CheckBox_AkcjaRuchPrzeciwny, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CheckBox_AkcjaRuchNaprzod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CheckBox_AkcjaZabojstwo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CheckBox_AkcjaZasieg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSpinner_WielkoscGenomu))
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(4, 4, 4)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jSpinner_LiczbaPopullacji)
                                                        .addComponent(jSpinner_LiczbaCykli)
                                                        .addComponent(jSpinner_LiczbaNeuronow, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(17, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(155, 155, 155)
                                                .addComponent(Button_ZaznaczDomyslny, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Button_Restartuj, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(170, 170, 170)
                                                .addComponent(jLabel1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Button_PrzygotujSymulacje, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Button_ZaznaczDomyslny, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Button_Restartuj, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(70, 70, 70)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jSpinner_LiczbaPopullacji, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jSpinner_WielkoscGenomu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jSpinner_LiczbaNeuronow, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jSpinner_LiczbaCykli, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(CheckBox_AkcjaCel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(CheckBox_AkcjaFeromon)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(CheckBox_AkcjaReaktywnosc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(CheckBox_AkcjaRuchE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(CheckBox_AkcjaRuchN)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(CheckBox_AkcjaRuchW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_AkcjaRuchS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_AkcjaRuchLosowy)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_AkcjaRuchPrzeciwny)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_AkcjaRuchNaprzod, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_AkcjaZabojstwo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_AkcjaZasieg)
                                                .addGap(86, 86, 86)
                                                .addComponent(Button_PrzygotujSymulacje, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(CheckBox_SensorFeromon)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorPopHor)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorPopWer)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorGestPop)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorGranicyNS)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorGranicyWE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorNajblizszejBariery)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorIstoty)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorLokalizacjiNS, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorLokalizacjiWE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorPrzeszkody)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorSrodka)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorBezpieczenstwa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CheckBox_SensorKierunkuPopulacji)))
                                .addGap(24, 24, 24))
        );

        CheckBox_SensorFeromon.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>


    private void Button_ZaznaczDomyslnyActionPerformed(java.awt.event.ActionEvent evt) {
        for(int i =0; i<ListaPrzyciskowSensorow.size(); i++){
            ListaPrzyciskowSensorow.get(i).setSelected(true);
        }
        for(int i =0; i< ListaPrzyciskowAkcji.size(); i++){
            ListaPrzyciskowAkcji.get(i).setSelected(true);
        }
        CheckBox_AkcjaZabojstwo.setSelected(false);
        CheckBox_SensorBezpieczenstwa.setSelected(false);
        jSpinner_LiczbaCykli.setValue(300);
        jSpinner_LiczbaNeuronow.setValue(3);
        jSpinner_LiczbaPopullacji.setValue(1000);
        jSpinner_WielkoscGenomu.setValue(12);

    }

    private void Button_PrzygotujSymulacjeActionPerformed(java.awt.event.ActionEvent evt) {
        boolean czyIstnijeSensor = false;
        boolean czyIstniejeAkcja = false;
        ArrayList<Boolean> jakieSensory = new ArrayList<Boolean>();
        ArrayList<Boolean> jakieAkcje = new ArrayList<Boolean>();

        for(int i =0; i<ListaPrzyciskowSensorow.size(); i++){
            jakieSensory.add(ListaPrzyciskowSensorow.get(i).isSelected());
            if(ListaPrzyciskowSensorow.get(i).isSelected()) czyIstnijeSensor = true;
        }
        for(int i =0; i< ListaPrzyciskowAkcji.size(); i++){
            jakieAkcje.add(ListaPrzyciskowAkcji.get(i).isSelected());
            if(ListaPrzyciskowAkcji.get(i).isSelected()) czyIstniejeAkcja = true;
        }

        if(czyIstnijeSensor && czyIstniejeAkcja) {
            int wPopulacji = (int) jSpinner_LiczbaPopullacji.getValue();
            int wGenomu = (int) jSpinner_WielkoscGenomu.getValue();
            int wCykli = (int) jSpinner_LiczbaCykli.getValue();
            int wNeuronow = (int) jSpinner_LiczbaNeuronow.getValue();
            Dane dane = new Dane(jakieSensory, jakieAkcje, wNeuronow, wPopulacji, wGenomu, wCykli);

            RS.getPG().getPanelek().setRysowacKropki(false);
            RS.getPG().FalszujWarunek();
            RS.getPG().FalszujBariery();
            RS.getPG().getPanelek().repaint();
            RS.getPG().setDane(dane);
            RS.setCzyPlikZaladowany( true);
            RS.getLabel_Procent().setText("");
            RS.getPG().setCzyPlikZapisany(false);
            RS.getButton_PrzygotujSym().setEnabled(true);
            RS.getButton_UruchomSymulacje().setEnabled(false);
            RS.getButton_NowaGeneracja().setEnabled(false);
            RS.setTitle("niezapisany");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

            RS.setNumerGen(0);
            RS.AktualizacjaStałych();
        }else{
            JOptionPane.showMessageDialog(this, "Należy wybrać przynajmniej jeden Sensor i Neuron Akcji", "Brak wybraych węzłów",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void Button_RestartujActionPerformed(java.awt.event.ActionEvent evt) {
        for(int i =0; i<ListaPrzyciskowSensorow.size(); i++){
            ListaPrzyciskowSensorow.get(i).setSelected(false);
        }
        for(int i =0; i< ListaPrzyciskowAkcji.size(); i++){
            ListaPrzyciskowAkcji.get(i).setSelected(false);
        }

        jSpinner_LiczbaCykli.setValue(100);
        jSpinner_LiczbaNeuronow.setValue(1);
        jSpinner_LiczbaPopullacji.setValue(2);
        jSpinner_WielkoscGenomu.setValue(1);

    }





    private javax.swing.JButton Button_PrzygotujSymulacje;
    private javax.swing.JButton Button_Restartuj;
    private javax.swing.JButton Button_ZaznaczDomyslny;
    private javax.swing.JCheckBox CheckBox_AkcjaCel;
    private javax.swing.JCheckBox CheckBox_AkcjaFeromon;
    private javax.swing.JCheckBox CheckBox_AkcjaReaktywnosc;
    private javax.swing.JCheckBox CheckBox_AkcjaRuchE;
    private javax.swing.JCheckBox CheckBox_AkcjaRuchLosowy;
    private javax.swing.JCheckBox CheckBox_AkcjaRuchN;
    private javax.swing.JCheckBox CheckBox_AkcjaRuchNaprzod;
    private javax.swing.JCheckBox CheckBox_AkcjaRuchPrzeciwny;
    private javax.swing.JCheckBox CheckBox_AkcjaRuchS;
    private javax.swing.JCheckBox CheckBox_AkcjaRuchW;
    private javax.swing.JCheckBox CheckBox_AkcjaZabojstwo;
    private javax.swing.JCheckBox CheckBox_AkcjaZasieg;
    private javax.swing.JCheckBox CheckBox_SensorBezpieczenstwa;
    private javax.swing.JCheckBox CheckBox_SensorFeromon;
    private javax.swing.JCheckBox CheckBox_SensorGestPop;
    private javax.swing.JCheckBox CheckBox_SensorGranicyNS;
    private javax.swing.JCheckBox CheckBox_SensorGranicyWE;
    private javax.swing.JCheckBox CheckBox_SensorIstoty;
    private javax.swing.JCheckBox CheckBox_SensorKierunkuPopulacji;
    private javax.swing.JCheckBox CheckBox_SensorLokalizacjiNS;
    private javax.swing.JCheckBox CheckBox_SensorLokalizacjiWE;
    private javax.swing.JCheckBox CheckBox_SensorNajblizszejBariery;
    private javax.swing.JCheckBox CheckBox_SensorPopHor;
    private javax.swing.JCheckBox CheckBox_SensorPopWer;
    private javax.swing.JCheckBox CheckBox_SensorPrzeszkody;
    private javax.swing.JCheckBox CheckBox_SensorSrodka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSpinner jSpinner_LiczbaCykli;
    private javax.swing.JSpinner jSpinner_LiczbaNeuronow;
    private javax.swing.JSpinner jSpinner_LiczbaPopullacji;
    private javax.swing.JSpinner jSpinner_WielkoscGenomu;

}
