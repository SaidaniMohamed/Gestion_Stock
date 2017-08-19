-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 19 Août 2017 à 18:44
-- Version du serveur :  10.1.16-MariaDB
-- Version de PHP :  5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_de_stock`
--

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `code_produit` varchar(50) DEFAULT NULL,
  `reference` varchar(50) DEFAULT NULL,
  `desiegnation` varchar(50) DEFAULT NULL,
  `rangemant` varchar(50) DEFAULT NULL,
  `fournisseur` varchar(50) DEFAULT NULL,
  `remise` int(11) DEFAULT NULL,
  `prix` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `code_produit`, `reference`, `desiegnation`, `rangemant`, `fournisseur`, `remise`, `prix`, `stock`) VALUES
(2, 'aaaa', 'bbb', 'ccc', 'ddd', 'eee', 100, 2222, 2297);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `id_user`, `username`, `password`, `type`) VALUES
(1, 9, 'abdrahman', 'sssssssss', 'directeur'),
(8, 77, 'a', 'jj', 'directeur'),
(556, 5, 'p', 'p', 'directeur'),
(557, 22, 'bbb', 'bbb', 'cachier'),
(558, 48, 'bilala', 'Saidani', 'directeur'),
(559, 888, 'bilala', 'Saidani', 'directeur'),
(560, 32, 'mohamed', 'saidani', 'directeur'),
(561, 54, 'zino', 'zino', 'directeur');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `id` int(11) NOT NULL,
  `num_facture` varchar(50) DEFAULT NULL,
  `code_produit` varchar(50) DEFAULT NULL,
  `reference` varchar(50) DEFAULT NULL,
  `prix_vente` int(11) DEFAULT NULL,
  `stock_sortie` int(11) DEFAULT NULL,
  `subtotal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `vente`
--

INSERT INTO `vente` (`id`, `num_facture`, `code_produit`, `reference`, `prix_vente`, `stock_sortie`, `subtotal`) VALUES
(1, 'aaa200', '1212', 'vecteur num 5', 200, 5, 1000),
(3, 'bbb300', '2323', 'vectnum6', 300, 6, 2000),
(4, '5555', 'aaaa', 'bbb', 2066, 10, 20665),
(5, '88', 'aaaa', 'bbb', 2066, 44, 90924),
(6, '123456789', 'aaaa', 'bbb', 2066, 11, 22731),
(7, '44', 'aaaa', 'bbb', 2066, 4, 8266),
(8, '14', 'aaaa', 'bbb', 2066, 2, 4133),
(9, '17', 'aaaa', 'bbb', 2066, 5, 10332),
(10, '1441', 'aaaa', 'bbb', 2066, 4, 8266),
(11, '1771', 'aaaa', 'bbb', 2066, 111, 229377),
(12, '8', 'aaaa', 'bbb', 2066, 7, 14465),
(13, '5', 'aaaa', 'bbb', 2066, 5, 10332),
(14, '1', 'aaaa', 'bbb', 2066, 4, 8266),
(15, '17', 'aaaa', 'bbb', 2066, 5, 10332),
(16, '111', 'aaaa', 'bbb', 2066, 5, 10332),
(17, '12', 'aaaa', 'bbb', 2066, 11, 22731),
(19, 'bb', 'aaaa', 'bbb', 2066, 11, 22731),
(20, 'bb', 'aaaa', 'bbb', 2066, 11, 22731),
(21, 'bb', 'aaaa', 'bbb', 2066, 11, 22731),
(22, '3', 'qs', 'qs', -303025, 210, -63635303),
(23, '1', 'qs', 'qs', -303025, 210, -63635303),
(24, '1112', 'aaaa', 'bbb', 2066, 1, 2066),
(25, '5556', 'aaaa', 'bbb', 2066, 4, 8266),
(26, '9', 'aaaa', 'bbb', 2066, 5, 10332),
(27, '47', 'aaaa', 'bbb', 2066, 54, 111589),
(28, '21', 'aaaa', 'bbb', 2066, 5, 10332),
(29, '12', 'aaaa', 'bbb', 2066, 22, 45462),
(30, '145', 'aaaa', 'bbb', 2066, 114, 235576);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=562;
--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
