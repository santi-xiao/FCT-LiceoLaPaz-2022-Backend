-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 07-06-2022 a las 18:06:33
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ecommercedb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(9, 'killers'),
(10, 'survivors');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `precio_final` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_producto`
--

CREATE TABLE `factura_producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` double DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `impuestos` int(11) NOT NULL,
  `descuento` int(11) DEFAULT NULL,
  `facturaid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE `oferta` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `activo` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `oferta`
--

INSERT INTO `oferta` (`id`, `cantidad`, `activo`) VALUES
(1, 20, 0),
(2, 40, 0),
(3, 60, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(254) DEFAULT NULL,
  `imagenDni` varchar(256) DEFAULT NULL,
  `imagenCuerpo` varchar(256) DEFAULT NULL,
  `precio` double NOT NULL,
  `oferta` int(11) DEFAULT NULL,
  `activo` tinyint(4) NOT NULL,
  `publico` tinyint(1) NOT NULL,
  `categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `imagenDni`, `imagenCuerpo`, `precio`, `oferta`, `activo`, `publico`, `categoria`) VALUES
(11, 'Trapper', 'The Trapper is an area-control Killer, able to apply pressure across the Map by placing deadly Bear Traps for Survivors to step into.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/dni/K01_charPreview_portrait_fp5fof.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934535/dbdstore/dbdstoreimages/killers/cuerpo/AK_TR_charPreview_zcg2da.webp', 9, 2, 1, 1, 9),
(12, 'The Wraith', 'The Wraith is a stealth Killer, able to cloak and uncloak at the ringing of his Wailing Bell.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/dni/K02_charPreview_portrait_wcqe3u.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934535/dbdstore/dbdstoreimages/killers/cuerpo/AK_WR_charPreview_rnyal2.webp', 20, NULL, 1, 1, 9),
(13, 'The Hilbilly', 'The Hillbilly is a high-mobility Killer, able to cover large distances in a short amount of time and instantly down Survivors using his Chainsaw.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K03_charPreview_portrait_itbg6q.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934535/dbdstore/dbdstoreimages/killers/cuerpo/AK_HI_charPreview_atmpvz.webp', 20.2, NULL, 1, 1, 9),
(14, 'The Nurse', 'The Nurse is a warping Killer, able to blink through obstacles and quickly close gaps with her Power.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K04_charPreview_portrait_ucbhip.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934535/dbdstore/dbdstoreimages/killers/cuerpo/BK_NU_charPreview_dfp0ox.webp', 20.2, NULL, 1, 1, 9),
(15, 'The Shape', 'The Shape is a haunting Killer, intent on monitoring Survivors from a distance to feed his Power. The more he stalks, the stronger and faster he becomes.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K05_charPreview_portrait_b6wlfo.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934535/dbdstore/dbdstoreimages/killers/cuerpo/CK_SH_charPreview_cmcbhh.webp', 20.2, NULL, 1, 1, 9),
(16, 'The Hag', 'The Hag is a cursed Killer, able to place Phantasm Traps and then teleport to them upon activation, using her Power.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K06_charPreview_portrait_i1prmp.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934535/dbdstore/dbdstoreimages/killers/cuerpo/DK_HA_charPreview_h22kxz.webp', 20.2, NULL, 1, 1, 9),
(17, 'The Doctor', 'The Doctor is a madness-inducing Killer, able to use his Power - Static Blast, incapacitating Survivors and causing them to hallucinate and scream in terror, revealing their position.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K07_charPreview_portrait_wmux0m.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934536/dbdstore/dbdstoreimages/killers/cuerpo/IK_DO_charPreview_yvroep.webp', 20.2, NULL, 1, 1, 9),
(18, 'The Huntress', 'The Huntress is a ranged Killer, able to throw Hunting Hatchets at Survivors to injure them from a distance.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K08_charPreview_portrait_rwwi03.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934536/dbdstore/dbdstoreimages/killers/cuerpo/JK_HU_charPreview_bcoc73.webp', 20.2, NULL, 1, 1, 9),
(19, 'The Cannibal', 'The Cannibal is a chainsaw-wielding Killer, able to trigger a deadly frenzy using his Power, immediately downing anyone in its path.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K09_charPreview_portrait_tbyz3a.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934536/dbdstore/dbdstoreimages/killers/cuerpo/JK_CA_charPreview_husim9.webp', 20, NULL, 1, 1, 9),
(20, 'The Nightmare', 'The Nightmare is a nightmare Killer, passively pulling Survivors into his Dream World where Survivors are vulnerable to his Dream Abilities. His Dream Projection ability allows him to quickly appear across the map and put pressure onto Survivors.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K10_charPreview_portrait_s0jonp.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934535/dbdstore/dbdstoreimages/killers/cuerpo/EK_NI_charPreview_kgjkv8.webp', 20.2, NULL, 1, 1, 9),
(21, 'The Pig', 'The Pig is a tormenting Killer, able to crouch into stealth mode, then ambush Survivors from a short distance. She can also apply Reverse Bear Traps to downed Survivors, forcing them to remove it before the timer runs out, triggering an instant death.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K11_charPreview_portrait_jehju3.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934535/dbdstore/dbdstoreimages/killers/cuerpo/FK_PI_charPreview_uqujmh.webp', 20.2, NULL, 1, 1, 9),
(22, 'The Clown', 'The Clown is a strategic Killer, able to control and corral Survivors by throwing bottles of The Afterpiece Tonic to create clouds of noxious gas that cover large areas for a short amount of time. Survivors intoxicated by the gas are inflicted with impai', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K12_charPreview_portrait_vcsjnb.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/cuerpo/StoreBackground_GK_wnf2lj.webp', 20.2, NULL, 1, 1, 9),
(23, 'The Spirit', 'The Spirit is a phase-walking Killer, able to catch Survivors off-guard with her traversal Power, Yamaokas Haunting. Her Power allows her to teleport from one place to another without being seen.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K13_charPreview_portrait_wsz4xv.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/cuerpo/StoreBackground_HK_th8mrr.webp', 20.2, NULL, 1, 1, 9),
(24, 'The Legion', 'The Legion are a band of merciless Killers, able to rush down helpless Survivors with their power, Feral Frenzy. Attacks made during their frenzy inflict lingering internal damage, downing any Survivors that are not quick enough to react.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K14_charPreview_portrait_jwyd3o.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/cuerpo/StoreBackground_KK_cvyhkv.webp', 20.2, NULL, 1, 1, 9),
(25, 'The Plague', 'The Plague is a devout Killer, able to infect Survivors from a short distance using her Power, Vile Purge. Survivors inflicted by this contamination risk becoming injured or broken, unless they find a way to cure themselves in a Pool of Devotion.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934538/dbdstore/dbdstoreimages/killers/dni/K15_charPreview_portrait_shdp8y.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/cuerpo/StoreBackground_MK_ousird.webp', 20.2, NULL, 1, 1, 9),
(26, 'The Ghost Face', 'The Ghost Face is a creepy Killer, able to stalk his victims and sneak up silently using his Power, Night Shroud. Affected Survivors will find themselves vulnerable and oblivious to his presence and must use all of their perception and awareness to prote', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K16_charPreview_portrait_km9exl.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/cuerpo/StoreBackground_OK_zhshsz.webp', 20, NULL, 1, 1, 9),
(27, 'The Demogorgon', 'The Demogorgon is an unidentified Killer, able to open multiple Portals and traverse between them to cover large distances. Using its Power, Of the Abyss, it can detect any Survivors within a close proximity to the Portals then unleash a leaping attack t', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K17_charPreview_portrait_btnq4p.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/cuerpo/StoreBackground_QK_z7mqlr.webp', 20.2, NULL, 1, 1, 9),
(28, 'The Oni', 'The Oni is a monstrous Killer, able to absorb the blood energy of his injured foes, and then use that energy to transform into a brutal demon. Using his power, Yamaokas Wrath, he can rush down Survivors at great speed and deal deadly strikes with his Kan', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K18_charPreview_portrait_s5tcms.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/cuerpo/StoreBackground_SK_jlvhcc.webp', 20.2, NULL, 1, 1, 9),
(29, 'The Deathslinger', 'The Deathslinger is a vengeful Killer, able to spear Survivors from a distance and reel them in using his Power, The Redeemer.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K19_charPreview_portrait_dnwqfg.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/cuerpo/UK_storeBackground_nxuqxi.webp', 20.2, NULL, 1, 1, 9),
(30, 'The Executioner', 'The Executioner is a map-manipulation Killer, able to torment Survivors with the hazards he creates. Affected Survivors will be vulnerable to his special Hook, the Cage of Atonement and his special mori, Final Judgement.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K20_charPreview_portrait_f7kf7k.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934536/dbdstore/dbdstoreimages/killers/cuerpo/K20_storeBackground_ttwhnf.webp', 20.2, NULL, 1, 1, 9),
(31, 'The Blight', 'The Blight is an unpredictable Killer, able to rush forward in a burst of speed and carom off obstacles to injure Survivors using his power, Blighted Corruption.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K21_charPreview_portrait_w2du2a.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/cuerpo/YK_storeBackground_n4kxyy.webp', 20.2, NULL, 1, 1, 9),
(32, 'The Twins', 'The Twins are a cooperative pair of Killers, able to divide and hunt together using their Power, Blood Bond', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K22_charPreview_portrait_f8ulmn.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934536/dbdstore/dbdstoreimages/killers/cuerpo/K22_storeBackground_ubnmcg.webp', 20.2, NULL, 1, 1, 9),
(33, 'The Trickster', 'The Trickster is a ranged Killer, able to quickly unleash a flurry of blades by using his power, Showstopper.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K23_charPreview_portrait_rhgwjw.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934536/dbdstore/dbdstoreimages/killers/cuerpo/K23_storeBackground_meimnl.webp', 20, NULL, 1, 1, 9),
(34, 'The Nemesis', 'The Nemesis is an unrelenting Killer, capable of attacking at mid-range with his tentacle, while receiving support from Zombies roaming the area.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K24_charPreview_portrait_rf0vxd.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934536/dbdstore/dbdstoreimages/killers/cuerpo/K24_storeBackground_g4qmii.webp', 20.2, NULL, 1, 1, 9),
(35, 'The Cenobite', 'The Cenobite is a summoning Killer, able to possess Chain Projectiles and use the Lament Configuration to torture every Survivor at once.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K25_charPreview_portrait_wdtme1.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934536/dbdstore/dbdstoreimages/killers/cuerpo/K25_storeBackground_y2m1ut.webp', 20.2, NULL, 1, 1, 9),
(36, 'The Artist', 'The Artist is a ranged-reconnaissance Killer, able to launch Dire Crows across the Map to reveal and attack Survivors.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934539/dbdstore/dbdstoreimages/killers/dni/K26_charPreview_portrait_og8jcl.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934536/dbdstore/dbdstoreimages/killers/cuerpo/K26_storeBackground_pljkjd.webp', 20.2, NULL, 1, 1, 9),
(37, 'The Onryō', 'The Onryō is a vengeful ghost imbued with the power of Nensha, the Onryō is able to silently and invisibly traverse the Realm, manifesting when she is ready to strike.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934540/dbdstore/dbdstoreimages/killers/dni/K27_charPreview_portrait_ankbe0.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934537/dbdstore/dbdstoreimages/killers/cuerpo/K27_storeBackground_knupmk.webp', 20.2, NULL, 1, 1, 9),
(38, 'Dwight Fairfield', 'Dwight Fairfield is a nervous Leader, able to locate his allies and increase their effectiveness.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934056/dbdstore/dbdstoreimages/survivors/dni/S01_charPreview_portrait_jjabmv.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/DwightStore_otdzkg.webp', 20, NULL, 1, 1, 10),
(39, 'Meg Thomas', 'Meg Thomas is an energetic Athlete, able to outrun most Killers.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934056/dbdstore/dbdstoreimages/survivors/dni/S02_charPreview_portrait_aspvlj.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/AS_MT_charPreview_b2uqe1.webp', 20, NULL, 1, 1, 10),
(40, 'Claudette Morel', 'Claudette Morel is a studious Botanist, able to boost her teams survivability as well as her own.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646933461/dbdstore/dbdstoreimages/survivors/dni/S03_charPreview_portrait_pszygd.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/AS_CM_charPreview_hhvwtl.webp', 20, NULL, 1, 1, 10),
(41, 'Jake Park', 'Jake Park is a solitary Survivalist, able to hold his own in most situations.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934056/dbdstore/dbdstoreimages/survivors/dni/S04_charPreview_portrait_hi8kap.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/JakeStore_shlp2z.webp', 20, NULL, 1, 1, 10),
(42, 'Nea Karlsson', 'Nea Karlsson is an Urban Artist, able to easily escape and hide.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934056/dbdstore/dbdstoreimages/survivors/dni/S05_charPreview_portrait_njty1q.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/NeaStore_wixdrx.webp', 20, NULL, 1, 1, 10),
(43, 'Laurie Strode', 'Laurie Strode is a determined Survivor, prepared to weather any challenge.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934057/dbdstore/dbdstoreimages/survivors/dni/S06_charPreview_portrait_kfj62p.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/LaurieStore_rrf8es.webp', 20, NULL, 1, 1, 10),
(44, 'Ace Visconti', 'Ace Visconti is a lucky Gambler, improving the odds of the entire team.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934057/dbdstore/dbdstoreimages/survivors/dni/S07_charPreview_portrait_lzkpur.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/DS_AV_charPreview_kxe7mp.webp', 20, NULL, 1, 1, 10),
(45, 'Bill Overbeck', 'Bill Overbeck is an old Soldier, accustomed to dealing with critical situations.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934057/dbdstore/dbdstoreimages/survivors/dni/S08_charPreview_portrait_yobtvv.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/DS_BO_charPreview_naoqh2.webp', 20, NULL, 1, 1, 10),
(46, 'Feng Min', 'Feng Min is an objective-focused competitor who can quickly adapt her strategy to meet a vast range of challenging situations.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934057/dbdstore/dbdstoreimages/survivors/dni/S09_charPreview_portrait_gesymy.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/FengStore_vrmbb1.webp', 20, NULL, 1, 1, 10),
(47, 'David King', 'David King is a rugged Scrapper, rewarding high-risk play.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934057/dbdstore/dbdstoreimages/survivors/dni/S10_charPreview_portrait_egyern.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/DavidStore_mfwqkg.webp', 20, NULL, 1, 1, 10),
(48, 'Quentin Smith', 'Quentin Smith is a resolute Dreamwalker, increasing the survivability and recovery of his team.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934057/dbdstore/dbdstoreimages/survivors/dni/S11_charPreview_portrait_kkxvgl.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/QuentinStore_ejxr6d.webp', 20, NULL, 1, 1, 10),
(49, 'David Tapp', 'David Tapp is an obsessed Detective, able to locate and complete Objectives faster.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934057/dbdstore/dbdstoreimages/survivors/dni/S12_charPreview_portrait_qtapjd.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934054/dbdstore/dbdstoreimages/survivors/cuerpo/FS_DT_charPreview_vpmcac.webp', 20, NULL, 1, 1, 10),
(50, 'Kate Denson', 'Kate Denson is a hopeful songbird, able to make the most of her surroundings.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934057/dbdstore/dbdstoreimages/survivors/dni/S13_charPreview_portrait_mo5uoz.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934055/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_GS_mrxeqe.webp', 20, NULL, 1, 1, 10),
(51, 'Adam Francis', 'Adam Francis is a resourceful Teacher, able to adapt to new circumstances and develop strategies accordingly.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934543/dbdstore/dbdstoreimages/survivors/dni/S14_charPreview_portrait_ojrc7r.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934055/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_HS_bru2nm.webp', 20, NULL, 1, 1, 10),
(52, 'Jeff Johansen', 'Jeff Johansen is a quiet artist with a heart of gold, standing steadfast against impossible odds. He has a dark past but led a quiet, simple life until his father passed, leaving things to sort out.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S15_charPreview_portrait_ghk9f4.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934541/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_KS_mtnt2q.webp', 20, NULL, 1, 1, 10),
(53, 'Jane Romero', 'Jane Romero is an influential celebrity, going against the grain to tackle challenges head on.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S16_charPreview_portrait_x6tdlp.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934542/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_MS_snr0kb.webp', 20, NULL, 1, 1, 10),
(54, 'Ash Williams', 'Ash Williams is an alone wolf, cocky and headstrong; a man built for survival.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S17_charPreview_portrait_nejmsy.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934541/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_AW_hor8by.webp', 20, NULL, 1, 1, 10),
(55, 'Nancy Wheeler', 'Nancy Wheeler is an aspiring journalist, able to make acute observations and gain insights that others may miss.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S18_charPreview_portrait_in492e.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934542/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_QF_vxohdb.webp', 20, NULL, 1, 1, 10),
(56, 'Steve Harrington', 'Steve Harrington is a former jock, able to protect and support his fellow Survivors while providing his own brand of humour.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S19_charPreview_portrait_pruznz.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934542/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_QM_papwfr.webp', 20, NULL, 1, 1, 10),
(57, 'Yui Kimura', 'Yui Kimura is a hardened street racer, able to gain advantages for her and her fellow Survivors in challenging situations.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S20_charPreview_portrait_qz4pph.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934542/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_SS_ouzvxk.webp', 20, NULL, 1, 1, 10),
(58, 'Zarina Kassir', 'Zarina Kassir is a plucky documentarian, able to use her street smarts to avoid detection and greatly assist other Survivors.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S21_charPreview_portrait_ln87th.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934542/dbdstore/dbdstoreimages/survivors/cuerpo/US_storeBackground_x64hkd.webp', 20, NULL, 1, 1, 10),
(59, 'Cheryl Mason', 'Cheryl Mason is a young Veteran of Terror, emboldening both herself and her team.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S22_charPreview_portrait_m4oo7e.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934542/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_WS_w66eqx.webp', 20, NULL, 1, 1, 10),
(60, 'Felix Richter', 'Felix Richter is a visionary architect, able to use his relentless determination to form a plan and help other Survivors.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S23_charPreview_portrait_uwytlg.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934542/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_YS_djdtbp.webp', 20, NULL, 1, 1, 10),
(61, 'Élodie Rakoto', 'Élodie Rakoto is an occult investigator, able to use cunning tricks and stubborn resolve to keep herself alive.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S24_charPreview_portrait_ovrxsx.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934542/dbdstore/dbdstoreimages/survivors/cuerpo/StoreBackground_S24_hjcovv.webp', 20, NULL, 1, 1, 10),
(62, 'Yun-Jin Lee', 'Yun-Jin Lee is a self-interested music producer, able to advance her goals during turbulent times.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S25_charPreview_portrait_dmgil6.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934541/dbdstore/dbdstoreimages/survivors/cuerpo/S25_storeBackground_nlvay6.webp', 19, NULL, 1, 1, 10),
(63, 'Jill Valentine', 'Jill Valentine is a founding member of S.T.A.R.S who has triumphed over countless bio-organic weapons.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934544/dbdstore/dbdstoreimages/survivors/dni/S26_charPreview_portrait_luzxxb.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934541/dbdstore/dbdstoreimages/survivors/cuerpo/S26_storeBackground_hkgivw.webp', 20, NULL, 1, 1, 10),
(64, 'Leon Scott Kennedy', 'Leon Scott Kennedy is a rookie police officer who went beyond the call of duty during the outbreak in Raccoon City.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934545/dbdstore/dbdstoreimages/survivors/dni/S27_charPreview_portrait_xpwlig.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934541/dbdstore/dbdstoreimages/survivors/cuerpo/S27_storeBackground_c5ftmo.webp', 20, NULL, 1, 1, 10),
(65, 'Mikaela Reid', 'Mikaela Reid is a young mystic, able to alter the trial with supernatural abilities.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934545/dbdstore/dbdstoreimages/survivors/dni/S28_charPreview_portrait_smr9pc.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934541/dbdstore/dbdstoreimages/survivors/cuerpo/S28_storeBackground_z4nyhy.webp', 20, NULL, 1, 1, 10),
(66, 'Jonah Vasquez', 'Jonah Vasquez is a mathematical mastermind, able to use logic to help his team.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934545/dbdstore/dbdstoreimages/survivors/dni/S29_charPreview_portrait_wbpwom.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934541/dbdstore/dbdstoreimages/survivors/cuerpo/S29_storeBackground_tpvqzz.webp', 20, NULL, 1, 1, 10),
(67, 'Yoichi Asakawa', 'Yoichi Asakawa is a brilliant marine biologist and psychic whose knowledge and abilities allow him to protect himself and assist others.', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934545/dbdstore/dbdstoreimages/survivors/dni/S30_charPreview_portrait_a60ezc.webp', 'https://res.cloudinary.com/dyefzpxc2/image/upload/v1646934541/dbdstore/dbdstoreimages/survivors/cuerpo/S30_storeBackground_gxpjlr.webp', 20, NULL, 1, 1, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id`, `nombre`) VALUES
(1, 'ADMIN'),
(2, 'USUARIO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `tipo` int(11) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `contraseña` varchar(256) NOT NULL,
  `email` varchar(200) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `activo` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `tipo`, `nombre`, `apellido`, `direccion`, `telefono`, `contraseña`, `email`, `fecha_nacimiento`, `activo`) VALUES
(5, 1, 'admin', 'capo', 'Rue del percebe', '600098765', '$2a$10$4h34MlP69/LJRJJGWhjRuu4Ej3UdOEdF4WNm19ksBlr4Yw/1THcXS', 'admin@admin.com', '1998-02-24', 1),
(21, 1, 'admin2', 'admin2', 'caslk', '12837412', '$2a$10$UYhx.JgIl.ZvW43Io.os9.g5VJhVFSrPaI9U6wjl49WdoUaMv9O7S', 'admin@admin.gal', '1998-02-24', 1),
(22, 1, 'santi', 'adsd', 'asdads', '12341234', '$2a$10$4VIAjfMd.ry.fjfgNRH3PuLLhw.oZaH16qUyltMSYkMT7NtiOp95S', 'santi@santi.com', '1998-02-24', 1),
(23, 2, 'test', 'test', 'test test 21', '600010203', '$2a$10$72mx4BJfEB7cIwpLVLlHg.7ClfSmbUD.XAwrys3Oa0qq17haGev8m', 'test@test.com', '1998-02-24', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuariofk` (`id_usuario`);

--
-- Indices de la tabla `factura_producto`
--
ALTER TABLE `factura_producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `facturafk` (`facturaid`);

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ofertafk` (`oferta`),
  ADD KEY `categorifk` (`categoria`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipo_usuariofk` (`tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `facturas`
--
ALTER TABLE `facturas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `factura_producto`
--
ALTER TABLE `factura_producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `oferta`
--
ALTER TABLE `oferta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `usuariofk` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura_producto`
--
ALTER TABLE `factura_producto`
  ADD CONSTRAINT `facturafk` FOREIGN KEY (`facturaid`) REFERENCES `facturas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `categorifk` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `ofertafk` FOREIGN KEY (`oferta`) REFERENCES `oferta` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `tipo_usuariofk` FOREIGN KEY (`tipo`) REFERENCES `tipo_usuario` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
