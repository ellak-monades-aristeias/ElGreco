CREATE DATABASE  IF NOT EXISTS `patreopolis_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `patreopolis_db`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: patreopolis_db
-- ------------------------------------------------------
-- Server version	5.5.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `question_id` int(1) NOT NULL AUTO_INCREMENT,
  `question_text` varchar(1000) DEFAULT NULL,
  `answer1` varchar(300) DEFAULT NULL,
  `answer2` varchar(300) DEFAULT NULL,
  `answer3` varchar(300) DEFAULT NULL,
  `answer4` varchar(300) DEFAULT NULL,
  `right_answer` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'1. Ποια από τις παρακάτω προτάσεις είναι η σωστή;','α. O Δομήνικος Θεοτοκόπουλος γεννήθηκε το 1541 στην Κρήτη , στο Ηράκλειο, που τότε ονομαζόταν Χάνδακας (Candia).','β. O Δομήνικος Θεοτοκόπουλος γεννήθηκε το 1641 στην Κρήτη , στα Χανιά, που τότε ονομαζόταν Χάνδακας (Candia). ','γ. O Δομήνικος Θεοτοκόπουλος γεννήθηκε στην Κρήτη , που τότε ήταν Τουρκοκρατούμενη. ','','α'),(2,'2. Οι πρώτες επιδράσεις που δέχτηκε ο Θεοτοκόπουλος προέρχονται:','α. Από τη βυζαντινή παράδοση','β. Από την αναγεννησιακή ιταλική ζωγραφική','γ. Από τη βυζαντινή παράδοση και την αναγεννησιακή ιταλική ζωγραφική.','','γ'),(3,'3. Ο πρώτος σταθμός του Θεοτοκόπουλου μετά τη μετακίνησή του από τη γενέτειρά του','α. Η Ρώμη','β. Η Βενετία','γ. Η Μαδρίτη','','β'),(4,'4. Στη βενετική περίοδο της δημιουργίας του ο Θεοτοκόπουλος φιλοτεχνεί έργα:','α. Μικρά σε μέγεθος, ζωγραφισμένα σε ξύλο με μεικτή τεχνική αυγοτέμπερας και λαδιού, \nεμπνευσμένα κυρίως από θρησκευτικά θέματα.','β. Ελαιογραφίες, μεγάλες σε μέγεθος, εμπνευσμένες κυρίως από θρησκευτικά θέματα.','γ. Καμία από τις παραπάνω απαντήσεις δεν είναι σωστή.','','α'),(5,'5. Κατά τη ρωμαϊκή περίοδο της δημιουργίας του ο Θεοτοκόπουλος:','α. Επηρεάστηκε πολύ από τη βυζαντινή παράδοση','β. Επηρεάστηκε από το μανιερισμό , τόσο με τη δημιουργία ψηλόλιγνων μορφών, \nόσο και με την προοπτική στην απόδοση των κτηρίων.','γ. Ακολούθησε δική του καλλιτεχνική πορεία χωρίς επιρροές από το χώρο που κινείτο.','','β'),(6,'6. Ποια από τις παρακάτω προτάσεις είναι η σωστή;','α. Ο Θεοτοκόπουλος μισούσε το Μιχαήλ Άγγελο .','β. Ο Θεοτοκόπουλος θαύμαζε το Μιχαήλ Άγγελο .','γ. Ο Θεοτοκόπουλος θαύμαζε και ταυτόχρονα απεχθανόταν το Μιχαήλ Άγγελο.','','γ'),(7,'7. Η μετακίνηση του Θεοτοκόπουλου από την Ιταλία στην Ισπανία οφείλεται κυρίως:','α. Στη διακήρυξη που έκανε για τις φιγούρες του Μιχαήλ Άγγελου στη ‘’Δευτέρα Παρουσία’’, \nη οποία αντιμετωπίστηκε ως ασέβεια στη μνήμη του Μιχαήλ Αγγέλου.','β. Στην επιθυμία του να γνωρίσει καινούριους τόπους.','γ. Στις καινούριες επαγγελματικές ευκαιρίες που αναζητούσε ο καλλιτέχνης.','','γ'),(8,'8. Ο τελικός προορισμός του Θεοτοκόπουλου στην Ισπανία ήταν:','α. Η Μαδρίτη','β. Το Τολέδο','γ. Το μοναστήρι Εσκοριάλ','','β'),(9,'9. Ποια από τις παρακάτω προτάσεις είναι η σωστή;','α. Ένα σημαντικό μέρος της καλλιτεχνικής δημιουργίας του Θεοτοκόπουλου στην Ισπανία\n εκτός από τα θρησκευτικά έργα αφορούν στις προσωπογραφίες. ','β. Ένα σημαντικό μέρος της καλλιτεχνικής δημιουργίας του Θεοτοκόπουλου στην Ισπανία \nεκτός από τα θρησκευτικά έργα αφορούν στις τοπιογραφίες.','γ. Οι καλλιτεχνικές δημιουργίες του Θεοτοκόπουλου στην Ισπανία δε συμπεριελάμβανε θρησκευτικά έργα.','','α'),(10,'10. Σχετικά με τις υπογραφές του Θεοτοκόπουλου παρατηρούμε ότι:','α. Οι ελληνικές υπογραφές του καλλιτέχνη μένουν σταθερές και αμετάβλητες.','β. Οι ελληνικές υπογραφές του καλλιτέχνη δε μένουν σταθερές και αμετάβλητες.','γ. Οι ελληνικές υπογραφές του καλλιτέχνη είναι μόνο μικρογράμματες.','','β'),(11,'11. Η αισθητική του Θεοτοκόπουλου δίνει μεγαλύτερη σημασία : \ni. Στο χρώμα και όχι το σχέδιο.\nii. Στην πιστή αναπαράσταση μορφών, πραγμάτων και τόπων τα οποία αποτελούν πηγές έμπνευσης των δημιουργιών του.\niii. Στη φαντασία και τη διαίσθηση του καλλιτέχνη. Από τις παρακάτω προτάσεις είναι σωστές:','α. Mόνο η i','β. Oι ii και iii','γ. Όλες','δ. Οι i και iii','δ'),(12,'12. Ως προς την απόδοση των σωμάτων κατά την ισπανική περίοδο της δημιουργίας του παρατηρούμε ότι:','α. Δε διαθέτουν αρμονία στις αναλογίες τους και συγκεκριμένα εντοπίζεται μια εσκεμμένη επιμήκυνσή τους.','β. Διαθέτουν αρμονία στις αναλογίες τους.','γ. Οι αναλογίες προσαρμόζονται στην έμπνευση της στιγμής.','','α'),(13,'13. Ποια από τις παρακάτω προτάσεις είναι η σωστή;','α. Ο Θεοτοκόπουλος ζούσε μόνος του και δε δημιούργησε ποτέ δική του οικογένεια.','β. Ο Θεοτοκόπουλος παντρεύτηκε και έκανε οικογένεια στο Τολέδο.','Γ. Ο Θεοτοκόπουλος δεν παντρεύτηκε ποτέ τη σύντροφό του με την οποία απέκτησε ένα γιο.','','γ'),(14,'14. Για το ρόλο που έχει το φως στην τέχνη του Θεοτοκόπουλου μπορούμε να κάνουμε τις εξής παρατηρήσεις: \ni. Tο φως παίζει καθοριστικό ρόλο στη διαμόρφωσή των προσώπων και των πραγμάτων ανάλογα προς την υφή που ο καλλιτέχνης του δίνει. \nii. Ο ιδιαίτερος τρόπος που το διαχειρίζεται ο Greco προσδίδει την εντύπωση του ανάγλυφου στις μορφές των προσώπων.\niii. Tο φως ακολουθεί τη φυσική πορεία στον πίνακα και φωτίζει ως φυσική πηγή τα αντικείμενα. Από τις παρακάτω προτάσεις είναι σωστή /ές:','α. Mόνο η i','β. Oι i και ii','γ. Oι ii και iii','','β'),(15,'15. Ποια από τις παρακάτω προτάσεις είναι η σωστή;','α. Ο Θεοτοκόπουλος είναι πολύ ακριβής στην απόδοση των αναλογιών στις ανθρώπινες μορφές.','β. Δεν εντοπίζονται διαφορές στη διάπλαση των ανθρώπινων και των θείων προσώπων.','γ. Η τέχνη των άκρων και κυρίως των χεριών που ζωγραφίζει είναι αξεπέραστη : φιλοτεχνεί χέρια ιδιαίτερα λεπτά,\n δάκτυλα κοντυλένια, που πολλές φορές ξεπερνούν τη φυσιολογική τους δομή.','','γ'),(16,'16. Ποια από τις παρακάτω προτάσεις είναι η σωστή;','α. Η ζωγραφική σημασία του έργου του εκτιμήθηκε όπως της άξιζε το 19ο αιώνα.','β. Οι ιστορικοί της τέχνης άμεσα αναγνώρισαν την αξία του έργου του.','γ. Ο Θεοτοκόπουλος δεν είχε αποκτήσει μεγάλη πελατεία στο Τολέδο.','','α'),(17,'17. Η επίδραση του έργου του Θεοτοκόπουλου στις επόμενες γενιές εντοπίζεται:','α. Στα έργα του Σεζάν','β. Στα έργα του Σεζάν και του Πικάσο.','γ. Στα έργα μόνο σύγχρονών του καλλιτεχνών και όχι μοντέρνων.','','β'),(18,'18. Ποια από τις παρακάτω προτάσεις είναι η σωστή;','α. Στην Ελλάδα εκτίθενται εννέα έργα του Θεοτοκόπουλου.','β. Στην Ελλάδα εκτίθενται έργα του Θεοτοκόπουλου που φιλοτέχνησε όταν βρισκόταν στη γενέτειρά του.','γ. Στην Ελλάδα δεν εκτίθεται κανένα έργο του Θεοτοκόπουλου από την ισπανική περίοδο των δημιουργιών του.','','α'),(19,'19. Ποια από τις παρακάτω προτάσεις είναι η σωστή;','α. Ο Θεοτοκόπουλος πέθανε στη Μαδρίτη το 1614.','β. Ο Θεοτοκόπουλος πέθανε στο Τολέδο το 1614.','γ. Ο Θεοτοκόπουλος πέθανε στη Ρώμη το 1613.','','β'),(20,'Μεταβαίνεις στη θέση 1. Παρακαλώ, απάντησε την ερώτηση!\nΠρωταγωνιστές στην αποτύπωση της σκηνής αυτής είναι δύο πρόσωπα της \nθρησκευτικής ζωής ,η βρεφοκρατούσα Παναγία και ένας Απόστολος.\n Πρόκειται για έργο που συνδυάζει στοιχεία του ιταλικού μανιερισμού και\n της παραδοσιακής τεχνοτροπίας  της  Kρητικής Σχολής. \n Είναι χαρακτηριστική η χρήση στοιχείων αναγεννησιακού χαρακτήρα, \nόπως το κάθισμα του Αποστόλου, το λοξό σκαμνί με το κουτί για τα\n χρώματα και επάνω ο άγγελος με το γυμνό πόδι, που πετώντας στεφανώνει τον Απόστολο. \nΠοιο είναι το έργο ; ','α. Ο Ευαγγελιστής Λουκάς ζωγραφίζει την εικόνα της Παναγίας Οδηγήτριας','β. Ο Ευαγγελισμός ','γ. Η ανάληψη της Παναγίας','','α'),(21,'Μεταβαίνεις στη θέση 3. Παρακαλώ, απάντησε την ερώτηση!\nO πίνακας παρουσιάζει την εικόνα των Θεοφανίων της δυτικής παράδοσης της αναγέννησης ,\n όπου η  Παναγία δίνει το βρέφος σε ένδειξη σεβασμού σε βασιλείς, καθισμένη σε\n μια κατεστραμμένη κατασκευή, σύμβολο της πτώσης των παγανιστικών θεών με τη\n γέννηση του Χριστού. Στο έργο αυτό αξίζει να προσέξουμε: το πρόσωπο της\n Παρθένου και του Χριστού που είναι ζωγραφισμένα με πολύ προσεκτική επιλογή\n χρωμάτων για να αποδώσουν με φωτεινότητα την όψη τους. Ο καλλιτέχνης\n επιλέγει την τεχνική της σκιαγράφησης των μορφών με παράλληλες μικρές γραμμές,\n για να αποδώσει με ακρίβεια την εκφραστικότητα των προσώπων. \nΤο έργο που περιγράφεται είναι:','α. Η προσκύνηση των μάγων','β.  Η Αγία Οικογένεια με την Αγία Άννα.','γ. Ο Ευαγγελισμός','','α'),(22,'Μεταβαίνεις στη θέση 4. Παρακαλώ, απάντησε την ερώτηση!\nΠρόκειται για μια πολυπρόσωπη σύνθεση στην οποία κυριαρχεί η κρητική τεχνοτροπία. \nΤο θέμα, όμως της ψυχής της Παναγίας και των Aγγέλων που  τη συνοδεύουν \nκαι κυριαρχεί στο έργο, σχετίζεται με το μανιερισμό  της εποχής. \nΣημαντική θέση στο έργο έχουν  επίσης ο Ιησούς και το Άγιο Πνεύμα με τη μορφή περιστεράς. \nΤο έργο που περιγράφεται είναι:','α. Η βάπτιση του Χριστού','β. Η Κοίμηση της Θεοτόκου','γ. Ο ενταφιασμός του Χριστού','','β'),(23,'Μεταβαίνεις στη θέση 6. Παρακαλώ, απάντησε την ερώτηση!\nΠρόκειται για ένα αριστούργημα που συμπυκνώνει τα χαρακτηριστικά\n της πιο μεγάλης ωριμότητας του Κρητικού ζωγράφου και φιλοτεχνήθηκε\n όταν ο δημιουργός βρισκόταν στην Ισπανία. Η διάταξη των προσώπων\n μέσα στον χώρο δίνει την εντύπωση ότι τα βλέπουμε μέσα από έναν\n κοίλο οβάλ καθρέφτη που συμβολίζει τον ουράνιο θόλο.  \nΗ μορφή της Παναγίας καταλαμβάνει το κέντρο της σύνθεσης.\n Με τα χέρια ενωμένα σε ευλαβική δέηση, στρέφει το βλέμμα \nπρος τον ουρανό, προς το χρυσό στέμμα της Βασίλισσας\n των Ουρανών, με το οποίο ετοιμάζονται \nνα την στεφανώσουν ο Χριστός και ο Θεός. \nΠοιο είναι το έργο ; ','α.  Η ανάληψη της Παναγίας','β. Η Παναγία του Ελέους','γ. Η Στέψη της Θεοτόκου','','γ'),(24,'Μεταβαίνεις στη θέση 8. Παρακαλώ, απάντησε την ερώτηση!\nΣτο έργο απεικονίζεται μια πανοραμική άποψη ενός ιερού τοπίου\n  όπου η χρήση των χρωμάτων, ο χειρισμός του φωτός ,\n η προοπτική, η απόδοση των ανθρώπων – προσκυνητών\n του προσδίδουν μια ιδιαίτερη γοητεία.\n Το έργο που περιγράφεται είναι:','α. Άποψη του Όρους και της Μονής Σινά','β. Άποψη και χάρτης του Τολέδο','γ. Το Τολέδο με καταιγίδα','','α'),(25,'Μεταβαίνεις στη θέση 9. Παρακαλώ, απάντησε την ερώτηση!\nΣτο έργο κυριαρχούν δύο πρόσωπα: ο άγιος  Ιωάννης και ο Χριστός.\n Παρατηρούμε την τυπική και ταυτόχρονα επιβλητική χειρονομία του\n Ιωάννη που σηκώνει το αδύνατο και ηλιοκαμμένο χέρι του  στο\n κεφάλι του Ιησού που με ευλάβεια σκύβει έχοντας κλειστά τα μάτια.\n Το θέμα έχει αποδοθεί από τον καλλιτέχνη και μεταγενέστερα.\n Το έργο που περιγράφεται είναι:','α. Άγιος Ιωάννης Ευαγγελιστής','β. Η Παναγία με το θείο βρέφος, με την Αγία Άννα και τον Άγιο Ιωάννη','γ. Η βάπτιση του Χριστού','','γ'),(26,'Μεταβαίνεις στη θέση 11. Παρακαλώ, απάντησε την ερώτηση!\nΠρόκειται για μια πολυπρόσωπη σύνθεση με ένα προσφιλές σε πολλούς\n καλλιτέχνες θέμα εμπνευσμένο από το βίο του  Ιησού.\n Κεντρική μορφή ο Χριστός, το κεφάλι του οποίου περιβάλλεται\n από ένα ακτινοβόλο φωτοστέφανο  σε σχήμα σταυρού. \nΑπέναντι και όχι δίπλα στα υπόλοιπα πρόσωπα της σύνθεσης κάθεται\n σε ένα σκαμνί ο Ιούδας. Τα χρώματα που κυριαρχούν είναι τα ροζ κα\nι τα πορτοκαλί συνδυασμένα με το πράσινο και αποτελούν προσπάθεια\n προσέγγισης της  ιταλικής τέχνης, αποκαλύπτοντας\n συγχρόνως τις επιδράσεις της βυζαντινής τέχνης.\n Ποιο είναι το έργο ;','α. Ο Μυστικός Δείπνος','β. Ο άγιος Ιούδας (Θαδαίος)','γ. Το δείπνο στο σπίτι του Σίμωνα','','α'),(27,'Μεταβαίνεις στη θέση 12. Παρακαλώ, απάντησε την ερώτηση!\nΠρώτη απόδοση του θέματος, στο οποίο κυριαρχεί η μορφή του\n Χριστού σ’ ένα από τα θαύματα του. Η άλλη μορφή είναι αυτή\n ενός απλού ανθρώπου που δέχεται την ευεργετική επίδραση\n του Κυρίου πάνω του. Το έργο συμβολίζει στο γενικότερο\n πλαίσιο της Αντιμεταρρύθμισης την αποκάλυψη της αληθινής\n πίστης από μέρος του Σωτήρα ή και πολύ απλούστερα\n τη δημιουργία του ανθρώπου. \nΤο έργο που περιγράφεται είναι:','α. Ο Χριστός στο σπίτι της Μάρθας και της Μαρίας','β. Η θεραπεία του τυφλού','γ. Η αλληγορία του χριστιανού ιππότη','','β'),(28,'Μεταβαίνεις στη θέση 13. Παρακαλώ, απάντησε την ερώτηση!\nΠρόκειται για έργο με  δύο όψεις. Στην κύρια όψη απεικονίζονται \n τρεις σκηνές: Η στέψη του χριστιανού ιππότη,\n Η Προσκύνηση των ποιμένων και η Βάπτιση του Χριστού.\n Στην πίσω όψη ο Γκρέκο φιλοτέχνησε: μία Άποψη του\n Όρους Σινά, τον Ευαγγελισμό  της Θεοτόκου και τους Πρωτόπλαστους. 	\nΣτο έργο αυτό μπορεί κάποιος να αναγνωρίσει χαρακτηριστικά της\n κρητικής παράδοσης, κυρίως στη μορφή του και στα σκαλίσματα\n του ξύλου. Υπάρχουν όμως ξεκάθαρα πρότυπα βενετσιάνικα ,\n κυρίως στο θέμα και την τεχνοτροπία. \nΑξιοπρόσεκτη είναι η ελευθερία του ζωγράφου στη χρήση του χρώματος.\nΤο έργο που περιγράφεται φέρει τον τίτλο  :','α.  Η Πέμπτη σφραγίδα της Αποκάλυψης','β. Η προσκύνηση του ονόματος του Χριστού','γ. Το τρίπτυχο της Μοδένας (Μόδενας)','','γ'),(29,'Μεταβαίνεις στη θέση 14. Παρακαλώ, απάντησε την ερώτηση!\nΠροσωπογραφία στην οποία απεικονίζεται ένας  διάσημος μικρογράφος\n και στενός φίλος του Θεοτοκόπουλου, ο οποίος μέσω επιστολής \nσυστήνει το Θεοτoκόπουλο στον προστάτη του, καρδινάλιο\n Αλεσάντρο Φαρνέζε ως «σπάνιο ταλέντο στη ζωγραφική». \nΣτο χέρι του προσώπου αυτού διακρίνεται ένα προσευχητάρι της Παναγίας. \nΤο έργο που περιγράφεται είναι:','α. Προσωπογραφία του Τζούλιο Κλόβιο','β. Προσωπογραφία ευπατρίδη','γ. Προσωπογραφία του Φράυ Ορτένσιο Φελίξ ντε Παλαβιτσίνο ','','α'),(30,'Μεταβαίνεις στη θέση 16. Παρακαλώ, απάντησε την ερώτηση!\nΗ σκηνή διαδραματίζεται σε ένα πλακόστρωτο δωμάτιο με τεράστιο \nάνοιγμα σε έναν συννεφιασμένο ουρανό. Μικροί άγγελοι πετούν\n στον ουρανό, ενώ το Άγιο Πνεύμα εμφανίζεται σαν λευκό\n περιστέρι μέσα σε χρυσό φως. Τα πρόσωπα που πρωταγωνιστούν\n είναι δύο:  ο Αρχάγγελος Γαβριήλ που κρατά ένα σκήπτρο και η\n Παναγία που μελετά από ένα ανοιχτό βιβλίο και στρέφεται\n ξαφνιασμένη με την εμφάνιση του Αρχαγγέλου που πετά. \nΚυριαρχούν τα τρία βασικά χρώματα, το μπλε στο φόρεμα της Παναγίας,\n το κίτρινο στον Αρχάγγελο και το κόκκινο στην κουρτίνα.\n Όλο το έργο, εκτός από το πλακόστρωτο, δείχνει να πάλλεται από κίνηση.\n Το θέμα αυτό έχει αποδοθεί πολλές φορές από τον καλλιτέχνη από τα \nπρώτα στάδια της πορείας του. Το συγκεκριμένο έργο φιλοτεχνήθηκε στην Ιταλία.\n Ποιο είναι το έργο ;','α. Η στέψη της Παναγίας.','β. Ο Ευαγγελισμός','γ. Η Ανάληψη της Παναγίας ','','β'),(31,'Μεταβαίνεις στη θέση 17. Παρακαλώ, απάντησε την ερώτηση!\nΗ επιλογή του θέματος αυτού συνδυάζεται με το γενικότερο κλίμα\n της Αντιμεταρρύθμισης που έχει αρχίσει να επικρατεί στην Ισπανία.\n Αναδεικνύεται έτσι  το ανανεωμένο ενδιαφέρον για τους πρώτους\n χριστιανούς μάρτυρες που ενθάρρυνε η Αντιμεταρρύθμιση. \nΤο έργο απομονώνει τρία στιγμιότυπα του επεισοδίου.\n Οι σκηνές που απεικονίζονται εξελίσσονται σε διαφορετικές \nχρονικές περιόδους και το ίδιο πρόσωπο παρουσιάζεται πολλές φορές.\n Σύμφωνα με την παράδοση ο πρωταγωνιστής και οι λεγεωνάριοί του\n βρήκαν φρικτό θάνατο από τις δυνάμεις του αυτοκράτορα Διοκλητιανού, \nδιότι αρνήθηκαν να προσφέρουν θυσίες σε ειδωλολατρικές θεότητες. \nΤο έργο που περιγράφεται είναι:','α. Το μαρτύριο του Αγίου Μαυρικίου','β. Ο Άγιος Σεβαστιανός','γ. Η Αλληγορία της Ιεράς Συμμαχίας ή το όνειρο του Φιλίππου.	','','α'),(32,'Μεταβαίνεις στη θέση 19. Παρακαλώ, απάντησε την ερώτηση!\nΤο έργο αυτό αποδίδει ένα χαρμόσυνο γεγονός με πρωταγωνιστή το Χριστό.\n Κυριαρχούν οι επιμήκεις φιγούρες, οι γεμάτες ένταση χειρονομίες των προσώπων\n, τα έντονα χρώματα και το παιχνίδι του φωτός που τονίζει τη μορφή του Κυρίου. \nΦιλοτεχνήθηκε στην Ισπανία. \nΤο έργο που περιγράφεται είναι:','α Η Ανάσταση','β. Η θεραπεία του τυφλού','γ. Η Βάπτιση του Χριστού','','α'),(33,'Μεταβαίνεις στη θέση 21. Παρακαλώ, απάντησε την ερώτηση!\nΤο έργο αυτό φιλοτεχνήθηκε στην Ισπανία και συγκεκριμένα  συμπλήρωνε \nτο υψηλότερο μέρος του πολύπτυχου που είχε παραγγελθεί στο Θεοτοκόπουλο \nγια την εκκλησία της μονής  Σάντο Δομίνγο ελ Αντίγουο. \n Πάνω στα συσσωρευμένα νέφη ο Θεός πατέρας ανάμεσα σε έξι αγγέλους σηκώνει\n το σώμα του νεκρού Χριστού. Πάνω στο φωτεινό ουρανό απεικονίζεται το περιστέρι\n του Αγίου Πνεύματος. Αξίζει να προσέξουμε ιδιαίτερα το άτονο, νεκρό σώμα του Χριστού \nκαι τη γεμάτη συγκίνηση έκφραση του προσώπου του Θεού.\n Το έργο που περιγράφεται είναι:','α. Η ταφή του Χριστού','β. Η Αγία Τριάδα','γ. Η προσκύνηση της Αγίας Τριάδας ','','β'),(34,'Μεταβαίνεις στη θέση 22. Παρακαλώ, απάντησε την ερώτηση!\nΗ πιο ώριμη εκδοχή ενός θέματος που απασχόλησε καλλιτεχνικά το \nΘεοτοκόπουλο στην Ισπανία και αποδόθηκε μέσα από πολλά έργα.\n Το κατακόρυφο σχήμα του πίνακα καθοδηγεί τη διαδρομή του\n βλέμματος  με ακολουθίες, επιταχύνσεις , στάσεις, διακοπές.\n Ερευνώντας τις μορφές παρατηρούμε ότι προβάλλονται σε έναν χώρο \nκενό και αφύσικο, χωρίς φόντο, με φωσφορίζοντα χρώματα και \nπαγωμένες χειρονομίες, σχεδόν σε μια μεγαλειώδη επανέκδοση των\n βυζαντινών εικόνων που θαύμασε ο καλλιτέχνης και αντέγραψε όταν\n ήταν νέος στην Κρήτη. Κυρίαρχη μορφή ο Χριστός , ο οποίος βιώνει το\n πάθος και πλαισιώνεται από οικεία του πρόσωπα, όπως η \nΠαναγία, η Μαγδαληνή, ο Άγιος Ιωάννης και οι Άγγελοι. \nΠοιο είναι το έργο ;','α. Η Σταύρωση','β. Η Ανάσταση','γ. Η προσευχή στη Γεσθημανή','','α'),(35,'Μεταβαίνεις στη θέση 23. Παρακαλώ, απάντησε την ερώτηση!\nΠρόκειται για μια από τις πιο γνωστές προσωπογραφίες του καλλιτέχνη, \nαπό τα πρώτα έργα της ισπανικής περιόδου. Μοντέλο θεωρείται ο\n Juan de Silva, μαρκήσιος de Montemayor, ο σπουδαιότερος \nσυμβολαιογράφος του Τολέδο. Δυστυχώς η συντήρηση του\n έργου είναι πολύ κακή, αφού το αριστερό χέρι έχει εξαφανιστεί\n εντελώς. Η θέση του δεξιού χεριού παραπέμπει ίσως σε τελετή\n ορκωμοσίας. Είναι χαρακτηριστική η τέχνη του Θεοτοκόπουλου\n στην απόδοση των άκρων, εδώ  παρατηρούμε τα μακριά δάκτυλα.\n Αξιοπρόσεκτο είναι επίσης και το βαθύ βλέμμα του προσώπου. \nΤο έργο που περιγράφεται είναι:','α. Ο ιππότης με το χέρι στο στήθος','β. Πορτρέτο του Felix Hortensio Paravicino','γ. Προσωπογραφία του Χόρχε Μανουέλ, γιου του Θεοτοκόπουλου. ','','α'),(36,'Μεταβαίνεις στη θέση 24. Παρακαλώ, απάντησε την ερώτηση!\nΤο έργο ανήκει στην τελευταία περίοδο του καλλιτέχνη και  το\n χαρακτηρίζει η πιο τονισμένη κατακόρυφη ανάπτυξη \nΑπεικονίζεται το Άγιο Πνεύμα που ως λευκό περιστέρι\n \"φωτίζει\" τους  Αποστόλους  για να διαδώσουν το λόγο \nτου Κυρίου σε πολλές διαφορετικές γλώσσες. Ο \"φωτισμός\" ή\n η επιφοίτηση του Αγ. Πνεύματος δηλώνεται με τη μορφή\nτης πύρινης γλώσσας πάνω από τα κεφάλια των Αποστόλων,\n ενώ στο κέντρο της  σύνθεσης βρίσκεται η Παναγία που διακρίνεται\n από το κόκκινο και μπλε χρώμα της ενδυμασίας της.\n Είναι φανερή η αντίθεση των μορφών που υπάρχουν στο κάτω μέρος\n του έργου με αυτές που συνθέτουν την ομάδα των προσώπων με την Παρθένο. \nΤο έργο που περιγράφεται είναι:','α. Το άνοιγμα της Πέμπτης Σφραγίδας της Αποκαλύψεως','β. Η Ανάληψη της Παναγίας','γ. Η Πεντηκοστή ','','γ'),(37,'Μεταβαίνεις στη θέση 26. Παρακαλώ, απάντησε την ερώτηση!\nΤο θέμα του έργου αυτού αντλείται από τα Πάθη του Χριστού.\n Στο κέντρο του  βρίσκεται  η γεμάτη φως και γλυκύτητα μορφή \nτου Χριστού, Γύρω του απεικονίζεται ένα πλήθος ανθρώπων\n που σχεδόν δεν ξεχωρίζουν λόγω της ομοιομορφίας των\n χρωμάτων και των μορφών τους , οι οποίες  έχουν μια ιδιαίτερη έκφραση.\n Ιδιαίτερη εντύπωση προκαλεί το πορφυρό χρώμα του μανδύα του Χριστού.\n Το έργο αυτό αποτέλεσε την πρώτη δημόσια αναγνώριση \nτης υψηλής τέχνης του δημιουργού του. \nΤο έργο που περιγράφεται είναι:','α. Η Σταύρωση','β. Ο Χριστός αίρων το Σταυρό','γ. Ο διαμερισμός των ιματίων (Εspolio)','','γ'),(38,'Μεταβαίνεις στη θέση 28. Παρακαλώ, απάντησε την ερώτηση!\nΘεωρείται αριστούργημα της παγκόσμιας Ιστορίας της Τέχνης και ίσως το καλύτερο\n έργο του δημιουργού. Ο πίνακας απεικονίζει ένα γεγονός που είχε συμβεί στον ίδιο\n χώρο, την εκκλησία του Αγίου Θωμά. Στο έργο αυτό αποδεικνύεται περίτρανα\n η τέχνη της προσωπογραφίας στην οποία διακρίνεται ο Θεοτοκόπουλος.\n Χωρίζεται σε δύο τμήματα. Το κάτω μέρος απεικονίζει μια τελετή, στην\n οποία παρευρίσκονται  όλες οι σημαντικές προσωπικότητες της πόλης \nτην εποχή του Ελ Γκρέκο. Αυτό είναι το γήινο τμήμα του έργου,\n στο οποίο  η ηρεμία και η ευλαβικότητα των προσώπων. \nΤο επάνω μέρος του πίνακα αρχίζει με ένα άγγελο ο οποίος αποτελεί\n το συνδετικό κρίκο των δυο μερών, του γήινου  και του  ουράνιου.\n Ο  Ιησούς , η Παρθένος Μαρία , ο Άγιος Ιωάννης ο Βαπτιστής και ο\n Άγιος Πέτρος είναι τα πρόσωπα που πρωταγωνιστούν στο τμήμα αυτό του έργου.\n Το έργο που περιγράφεται είναι:','α. Η εκδίωξη των εμπόρων από το ναό.','β. Η ταφή του κόμητος Οργκάθ.','γ. Το άνοιγμα της Πέμπτης Σφραγίδας της Αποκαλύψεως','','β'),(39,'Μεταβαίνεις στη θέση 29. Παρακαλώ, απάντησε την ερώτηση!\nTo θαύμα της μητρότητας απεικονίζεται μοναδικά στο έργο αυτό .\nΤα πρόσωπα που απεικονίζονται είναι η Παναγία, ο Χριστός , ο Ιωσήφ και η Αγία Άννα.\n Η γλυκύτητα της έκφρασης της Παναγίας είναι αξιοπρόσεκτη και ιδιαίτερα\n αντιπροσωπευτική των μηνυμάτων που μεταδίδει ο καλλιτέχνης , \nαφού ως πνευματικός άνθρωπος και όχι μόνο ως καλλιτέχνης προσπαθεί \nνα μεταδώσει παιδαγωγικά μηνύματα μέσα από τις δημιουργίες του.\n Η στενή σχέση μητέρας παιδιού, η οποία αποτυπώνεται μέσα από τα πρόσωπα\n του έργου αποτελεί ένα από αυτά τα μηνύματα, ιδιαίτερα χρήσιμο για την εποχή του,\n όπου οι γυναίκες συνήθιζαν να  αναθέτουν το μεγάλωμα των  νεογέννητων βρεφών\n τους σε τροφούς στην εξοχή, με ενδεχόμενο αποτέλεσμα τη μεγάλη θνησιμότητα των βρεφών,\n την πιθανή εξαφάνισή τους και την καταστροφή του συνεκτικού δεσμού μητέρας-παιδιού,\n που είναι καθοριστική για τη διαμόρφωση της προσωπικότητάς του. \nΤο έργο που περιγράφεται είναι:','α. Η Αγία οικογένεια με την Αγία Άννα','β. Η Αγία οικογένεια με τη Μαγδαληνή ','γ. Η Αγία οικογένεια με την Αγία Άννα  και τον Ιωάννη τον Βαπτιστή.','','α'),(40,'Μεταβαίνεις στη θέση 31. Παρακαλώ, απάντησε την ερώτηση!\nΗ σκηνή που αποδίδεται αφορά σε ένα γεγονός με πρωταγωνιστή τον Ιησού,\n ο οποίος κρατά στο χέρι του ένα φραγγέλιο (είδος μαστιγίου) και πηγή έμπνευσής \nτου είναι οι ευαγγελικές πηγές. Η μορφή του Κυρίου βρίσκεται στο κέντρο\n του έργου και τα κόκκινα ενδύματά του τονίζουν ακόμα περισσότερο το \nρόλο του Χριστού. Στο γενικότερο κλίμα της αντιμεταρρύθμισης που επικρατεί ,\n το έργο δηλώνει την κάθαρση της Εκκλησίας. Η σύνθεση είναι\n πολυπρόσωπη και αξιοσημείωτο είναι ότι τα συναισθήματα των υπολοίπων\n προσώπων που απεικονίζονται, διαγράφονται  έντονα στα πρόσωπα και τις κινήσεις τους. \nΤο έργο που περιγράφεται είναι:','α. Ο διαμερισμός των ιματίων','β. Η θεραπεία του τυφλού','γ. Η εκδίωξη των εμπόρων από το ναό ','','γ'),(41,'Μεταβαίνεις στη θέση 32. Παρακαλώ, απάντησε την ερώτηση!\nΜια διάσημη προσωπογραφία ενός σημαντικού προσώπου από το χώρο της Εκκλησίας,\n η οποία κατατάσσεται στα πιο μεγαλοπρεπή έργα όχι μόνο του Γκρέκο αλλά και όλης\n της ισπανικής ζωγραφικής. Ξεχωρίζει για τη συνθετική της αρτιότητα και την\n εκφραστική της  δύναμη. Κυριαρχούν τα έντονα χρώματα  στα  ενδύματα του\n προσώπου που απεικονίζεται αλλά και το αυστηρό βλέμμα του, το οποίο ο καλλιτέχνης\n προσπαθεί να μειώσει με τις αντανακλάσεις του φωτός πάνω στα ενδύματα και την\n λαμπερή ταπετσαρία του τοίχου . Ο  Γκρέκο  απεικόνισε το πρόσωπο αυτό\n φορώντας γυαλιά , γεγονός που αντιμετωπίστηκε ως βλασφημία και  τον οδήγησε  στην Ιερά Εξέταση.\n Το έργο που περιγράφεται είναι:','α. Ο Άγιος Λουδοβίκος της Γαλλίας και ένας νεαρός βαλές','β. Καρδινάλιος Νίνιο ντε Γκεβάρα','γ. Ο Άγιος Ιερώνυμος ως Καρδινάλιος','','β'),(42,'Μεταβαίνεις στη θέση 34. Παρακαλώ, απάντησε την ερώτηση!\nΈνα από τα πιο δημοφιλή θέματα της θρησκευτικής εικονογραφίας της εποχής,\n με το οποίο ο Γκρέκο ασχολήθηκε πολλές φορές. Το συγκεκριμένο αποτελεί\n μια από τις καλύτερες εκδοχές απόδοσης του θέματος των παθών του Κυρίου. \nΑπεικονίζεται μόνο ο Χριστός και μάλιστα περισσότερο από το μισό του σώματος Του, \n το οποίο μάλιστα θεάται από κάτω, χωρίς να υπάρχει καμία οπτική επικοινωνία\n ανάμεσα στο βλέμμα Του και αυτό του θεατή. Η έκφρασή Του δεν αποδίδει το πάθος ,\n αλλά την εγκαρτέρηση. Αποτυπώνεται η σιωπηλή επικοινωνία Του με το Θεό.\n Το έργο που περιγράφεται είναι:','α. Ο Χριστός αίρων το σταυρόν','β. Η Σταύρωση','γ. Ο Σωτήρας','','α'),(43,'Μεταβαίνεις στη θέση 36. Παρακαλώ, απάντησε την ερώτηση!\nΠρόκειται για ένα από τα αριστουργήματα του Θεοτοκόπουλου , \nτο οποίο φιλοτεχνήθηκε κατά τα τελευταία χρόνια της ζωής του.\n Σε πρώτο πλάνο εικονίζεται ο Άγιος Ιωάννης γονατιστός με τα χέρια \nυψωμένα να  κοιτάζει τον ουρανό. Σε δεύτερο πλάνο παρατηρούμε \n γυμνές φιγούρες με  ταραγμένες χειρονομίες. Το έργο αποδίδει με\n πολύ ιδιαίτερο τρόπο τη φοβερή εικόνα της Ημέρας της Κρίσεως. \nΤο έργο που περιγράφεται είναι:','α. Η Πέμπτη Σφραγίδα της Αποκαλύψεως','β. Λαοκόων','γ. Εσταυρωμένος με την Παναγία, έναν δωρητή και τον Άγιο Ιωάννη τον Ευαγγελιστή ','','α'),(44,'Μεταβαίνεις στη θέση 37. Παρακαλώ, απάντησε την ερώτηση!\nΑπεικονίζεται ο τόπος που έπαιξε καθοριστικό ρόλο στη ζωή του Θεοτοκόπουλου,\n ιδωμένος με τα μάτια της ψυχής του καλλιτέχνη. Ο Θεοτοκόπουλος στο έργο αυτό,\n που είναι της τελευταίας περιόδου της δημιουργίας του, δεν είχε σκοπό\n απλά να αντιγράψει πιστά το τοπίο, αλλά να αποδώσει το όραμα που είχε\n συλλάβει για τον τόπο αυτό. Τα χρώματα που κυριαρχούν είναι το πράσινο των\n θάμνων και το γαλανό του ποταμού, καθώς και το γκρίζο από τα σύννεφα\n και το μελανό του ουρανού που φωτίζεται από τις αστραπές.\n Η καταιγίδα είναι έτοιμη να ξεσπάσει και τονίζει τα οικοδομήματα της περιοχής.\n Το έργο διακρίνεται για τον ονειροπόλο χαρακτήρα του και την υπέροχη πνευματικότητά του.\n Το έργο που περιγράφεται είναι:','α. Άποψη του όρους Σινά','β. Άποψη του Τολέδο (Το Τολέδο με καταιγίδα)','γ. Άποψη και χάρτης του Τολέδο','','β'),(45,'Μεταβαίνεις στη θέση 38. Παρακαλώ, απάντησε την ερώτηση!\nΟ συγκεκριμένος πίνακας αποδίδει το περιστατικό σύμφωνα με το οποίο ο \nπρωταγωνιστής του είναι ένα πρόσωπο που την εποχή της Αντιμεταρρύθμισης \nαποτελούσε το σύμβολο του χριστιανικού ελέους. Στη σκηνή υπάρχει ένα ακόμα πρόσωπο.\n Ο Θεοτοκόπουλος αντικρίζει τα δύο πρόσωπα από χαμηλωμένη οπτική \nγωνία με τρόπο ώστε να φαίνονται σα να είναι τοποθετημένα σε ένα ανυψωμένο επίπεδο,\n όπου ξεχωρίζουν με επιβλητικότητα. Στο βάθος απεικονίζεται μια άποψη του Τολέδο\n με τη γέφυρα της Αλκάνταρα στον ποταμό Τάγο,\n ενώ θα έπρεπε να απεικονίζεται η πόλη Αμιέν, όπου έγινε η συνάντηση των δύο προσώπων.\n Ποιο είναι το έργο ;','α. Ο Άγιος Μαρτίνος μοιράζεται το μανδύα του μ’ έναν ζητιάνο','β. Οι Άγιοι Ιωάννης ο Ευαγγελιστής και Φραγκίσκος','γ. Ο Άγιος Ανδρέας και ο Φραγκίσκος','','α'),(46,'Μεταβαίνεις στη θέση 39. Παρακαλώ, απάντησε την ερώτηση!\nΠρόκειται για ένα έργο με μυθολογικό θέμα, κάτι που δεν ήταν ιδιαίτερα συνηθισμένο\n για τον καλλιτέχνη που φιλοτεχνούσε περισσότερο θέματα θρησκευτικού περιεχομένου.\n Αποτυπώνεται στο έργο αυτό η τραγική ιστορία του ιερέα του Απόλλωνα στην Τροία,\n ο οποίος κατασπαράχθηκε μαζί με τα παιδιά του από φρικτά φίδια που αναδύθηκαν\n μέσα από τη θάλασσα   στην ακτή μπροστά από την Τροία, αφού είχε εκφράσει την\n αντίθεσή του να μεταφερθεί ο Δούρειος Ίππος μέσα στα τείχη της Τροίας. \nΗ τιμωρία του είχε ως αποτέλεσμα να δεχθούν το Δούρειο Ίππο και να ηττηθούν από τους Έλληνες.\n Στην απόδοση του θέματος από τον Γκρέκο είναι φανερή η τεχνοτροπία της τελευταίας περιόδου. \nΤο έργο χαρακτηρίζεται από έντονο  ενδιαφέρον για τη μελέτη του γυμνού.  \nΤο έργο που περιγράφεται είναι:','α. Ο Αδάμ και η Εύα παρουσία του αιωνίου','β. Ο Λαοκόων','γ. Ο Άγιος Ιερώνυμος μετανοών','','β'),(47,'1. Για να μπορέσουμε να κατανοήσουμε την τέχνη του Δομήνικου Θεοτοκόπουλου, θα πρέπει να λάβουμε υπόψη μας:\n i. Την ασυνήθιστη ουμανιστική και τεχνική μόρφωσή του.\nii. Την έξοχη διάνοιά του και τις φιλοσοφικές και θρησκευτικές του αντιλήψεις.\niii. Τις επιδράσεις που δέχτηκε στις χώρες που κατά καιρούς έζησε.Από τις παρακάτω προτάσεις είναι σωστή /ές:     ','α. Mόνο η i','β. Oι ii και iii','γ. Όλες','','γ'),(48,'2. Ο Δομήνικος Θεοτοκόπουλος αποτέλεσε πηγή έμπνευσης για την αυτοβιογραφία \n‘’Αναφορά στο Γκρέκο’’ τον Έλληνα λογοτέχνη :',' α. Κωνσταντίνου Πρεβελάκη',' β. Νίκου Καζαντζάκη','γ. Μανόλη Χατζηδάκη','','β'),(49,'3. Ποια από τις παρακάτω προτάσεις είναι η σωστή;',' α. Η πλειοψηφία των έργων του Θεοτοκόπουλου εκτίθεται στην Ελλάδα','β. Η πλειοψηφία των έργων του Θεοτοκόπουλου εκτίθεται στην Ισπανία.','  γ. Η πλειοψηφία των έργων του Θεοτοκόπουλου εκτίθεται στις ΗΠΑ.','','β'),(50,'4. Ποια από τις παρακάτω προτάσεις είναι η σωστή;',' α. Το προσωνύμιο El Greco  αποδόθηκε στο Θεοτοκόπουλο όσο βρισκόταν στην Ιταλία.','β. Το προσωνύμιο El Greco  αποδόθηκε στο Θεοτοκόπουλο όσο βρισκόταν στην Ισπανία.','γ. Το προσωνύμιο El Greco  υιοθετήθηκε από τον καλλιτέχνη και ως υπογραφή των  έργων του.','','α'),(51,'5. Η στάση του καλλιτέχνη απέναντι στο γυναικείο φύλο:\n i . Η στάση προς τη γυναικεία φύση ήταν θετική , αφού ο καλλιτέχνης ήταν γνήσιος  ουμανιστής και φιλόσοφος.\n ii. Όπως και η πλειοψηφία των ανθρώπων της εποχής αντιμετώπιζε τη γυναίκα ως  «πλάσμα προορισμένο για το κακό». \n iii. Ήθελε να αντιμετωπίσει μέσα από τα έργα του τις γυναίκες   ως ισότιμες  με τους  άνδρες. iv. Αδιαφορούσε για το γυναικείο φύλο.\n Από τις παρακάτω προτάσεις είναι σωστή /ές:','  α. Mόνο η i','  β. Oι i και iii ','γ. Mόνο η ii',' δ. Μόνο η iv','β'),(52,'6. Ποια από τις παρακάτω προτάσεις είναι η σωστή;   ','α. Στις ώριμες δημιουργίες του ο Θεοτοκόπουλος τοποθετεί στο πάνω μέρος του έργου\n τις γήινες μορφές και στο κάτω τις θεϊκές.','β. Στις ώριμες δημιουργίες του ο Θεοτοκόπουλος τοποθετεί στο κάτω μέρος του έργου \nτις γήινες μορφές ζωγραφισμένες με αφύσικο ύφος και στο πάνω τις θεϊκές  ζωγραφισμένες  ρεαλιστικά.','γ. Στις ώριμες δημιουργίες του ο Θεοτοκόπουλος τοποθετεί στο κάτω μέρος του έργου  τις γήινες\n μορφές ζωγραφισμένες ρεαλιστικά και στο πάνω τις θεϊκές  ζωγραφισμένες  έτσι ώστε να μοιάζουν εξαϋλωμένες.','','γ');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-30 20:45:44