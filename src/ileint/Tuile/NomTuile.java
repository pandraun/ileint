package ileint.Tuile;

/**
 *
 * @author fodorg
 */
public enum NomTuile {
    Le_Pont_des_Abimes("Le Pont des Abîmes"),
    La_Porte_de_Bronze("La Porte de Bronze"),
    La_Caverne_des_Ombres("La Caverne des Ombres"),
    La_Porte_de_Fer("La Porte de Fer"),
    La_Porte_d_Or("La Porte d'Or"),
    Les_Falaises_de_l_Oubli("Les Falaises de l'Oubli"),
    Le_Palais_de_Corail("Le Palais de Corail"),
    La_Porte_d_Argent("La Porte d'Argent"),
    Les_Dunes_de_l_Illusion("Les Dunes de l'Illusion"),
    Heliport("Héliport"),
    La_Porte_de_Cuivre("La Porte de Cuivre"),
    Le_Jardin_des_Hurlements("Le Jardin des Hurlements"),
    La_Foret_Pourpre("La Forêt Pourpre"),
    Le_Lagon_Perdu("Le Lagon Perdu"),
    Le_Marais_Brumeux("Le Marais Brumeux"),
    Observatoire("Observatoire"),
    Le_Rocher_Fantome("Le Rocher Fantôme"),
    La_Caverne_du_Brasier("La Caverne du Brasier"),
    Le_Temple_du_Soleil("Le Temple du Soleil"),
    Le_Temple_de_La_Lune("Le Temple de la Lune"),
    Le_Palais_des_Marees("Le Palais des Marées"),
    Le_Val_du_Crepuscule("Le Val du Crépuscule"),
    La_Tour_du_Guet("La Tour de Guet"),
    Le_Jardin_des_Murmures("Le Jardin des Murmures");
    
    String libelle ;
        
        NomTuile(String libelle) {
            this.libelle = libelle ;
        }

        @Override
        public String toString() {
            return this.libelle ;
        }
}
