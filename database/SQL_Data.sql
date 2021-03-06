USE [master]
GO
/****** Object:  Database [BookStoreOnline]    Script Date: 7/14/2021 10:18:37 PM ******/
CREATE DATABASE [BookStoreOnline]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookStoreOnline', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\BookStoreOnline.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'BookStoreOnline_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\BookStoreOnline_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [BookStoreOnline] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookStoreOnline].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookStoreOnline] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookStoreOnline] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookStoreOnline] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookStoreOnline] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookStoreOnline] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookStoreOnline] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BookStoreOnline] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookStoreOnline] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookStoreOnline] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookStoreOnline] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookStoreOnline] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookStoreOnline] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookStoreOnline] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookStoreOnline] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookStoreOnline] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BookStoreOnline] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookStoreOnline] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookStoreOnline] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookStoreOnline] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookStoreOnline] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookStoreOnline] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookStoreOnline] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookStoreOnline] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BookStoreOnline] SET  MULTI_USER 
GO
ALTER DATABASE [BookStoreOnline] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookStoreOnline] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookStoreOnline] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookStoreOnline] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [BookStoreOnline] SET DELAYED_DURABILITY = DISABLED 
GO
USE [BookStoreOnline]
GO
/****** Object:  Table [dbo].[Book]    Script Date: 7/14/2021 10:18:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Book](
	[bookID] [int] IDENTITY(1,1) NOT NULL,
	[bookName] [nvarchar](100) NULL,
	[bookStatus] [varchar](20) NULL,
	[bookImage] [varchar](200) NULL,
	[bookPrice] [float] NULL,
	[bookQuantity] [int] NULL,
	[bookCreateDate] [datetime] NULL,
	[categoryID] [varchar](50) NULL,
	[bookAuthor] [nvarchar](100) NULL,
	[bookDescription] [nvarchar](max) NULL,
 CONSTRAINT [PK_Books] PRIMARY KEY CLUSTERED 
(
	[bookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Category]    Script Date: 7/14/2021 10:18:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Category](
	[categoryID] [varchar](50) NOT NULL,
	[categoryName] [nvarchar](100) NULL,
	[categoryStatus] [varchar](20) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Discount]    Script Date: 7/14/2021 10:18:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Discount](
	[discountID] [varchar](50) NOT NULL,
	[discountName] [varchar](100) NULL,
	[discountPercent] [float] NULL,
	[discountStatus] [varchar](20) NULL,
	[createDate] [datetime] NULL,
	[userID] [varchar](100) NULL,
 CONSTRAINT [PK_Discounts] PRIMARY KEY CLUSTERED 
(
	[discountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Order]    Script Date: 7/14/2021 10:18:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Order](
	[orderID] [varchar](100) NOT NULL,
	[userID] [varchar](100) NULL,
	[orderDate] [datetime] NULL,
	[orderStatus] [varchar](20) NULL,
	[orderAddress] [nvarchar](100) NULL,
	[orderPhone] [nvarchar](20) NULL,
	[orderTotal] [float] NULL,
	[discountID] [varchar](50) NULL,
	[orderType] [varchar](50) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 7/14/2021 10:18:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[orderDetailID] [int] IDENTITY(1,1) NOT NULL,
	[bookID] [int] NULL,
	[amount] [int] NULL,
	[orderID] [varchar](100) NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[orderDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Role]    Script Date: 7/14/2021 10:18:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Role](
	[roleID] [varchar](20) NOT NULL,
	[roleName] [varchar](50) NULL,
	[roleStatus] [varchar](20) NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[User]    Script Date: 7/14/2021 10:18:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[User](
	[userID] [varchar](100) NOT NULL,
	[password] [varchar](100) NULL,
	[userName] [nvarchar](100) NULL,
	[userPhone] [varchar](20) NULL,
	[userEmail] [varchar](100) NULL,
	[roleID] [varchar](20) NULL,
	[userStatus] [varchar](20) NULL,
	[userCreateDate] [datetime] NULL,
	[userAddress] [nvarchar](100) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Book] ON 

INSERT [dbo].[Book] ([bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate], [categoryID], [bookAuthor], [bookDescription]) VALUES (8, N'Diary of a Wimpy Kid', N'active', N'assets/img/facff1d4a8406ec5344f74f5125c8446.jpg', 11, 0, CAST(N'2021-06-27 16:11:10.037' AS DateTime), N'CB', N'Jeff Kinney', N'*The sixth laugh-out-loud, fully illustrated bestselling Wimpy Kid book!*

A snowstorm SHOULD bring nothing but fun. Hours in front of the TV, cuddling up with a blanket and NO SCHOOL... But not for Greg Heffley.

Being trapped inside with his family is bad enough, but it''s even worse when the POLICE are trying to track him down.

School property has been damaged, and Greg''s the prime suspect. But he''s INNOCENT! Sort of. Is time finally up for Greg Heffley?')
INSERT [dbo].[Book] ([bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate], [categoryID], [bookAuthor], [bookDescription]) VALUES (9, N'Peppa Pig: Summer Fun! Sticker Activity Book', N'active', N'assets/img/fc965352734288ce25ff47491174e4b9.jpg', 16, 14, CAST(N'2021-06-27 16:12:57.563' AS DateTime), N'CB', N'Peppa Pig', N'Peppa, George and all their friends enjoy the summer at fetes, funfairs, picnics and the beach too. With lots of puzzles and activities this sticker book will keep all little Peppa fans busy.
Based on the hit pre-school animation, Peppa Pig, shown daily on Five''s Milkshake and Nick Jnr.')
INSERT [dbo].[Book] ([bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate], [categoryID], [bookAuthor], [bookDescription]) VALUES (10, N'Call Me By Your Name (Now a Major Motion Picture)', N'active', N'assets/img/98fbb7ffdcccb5d6679b9818e8a27e6b.jpg', 15, 5, CAST(N'2021-06-27 00:00:00.000' AS DateTime), N'NO', N'Andr Aciman', N'Andre Aciman''s Call Me by Your Name is the story of a sudden and powerful romance that blossoms between an adolescent boy and a summer guest at his parents'' cliffside mansion on the Italian Riviera. Each is unprepared for the consequences of their attraction, when, during the restless summer weeks, unrelenting currents of obsession, fascination, and desire intensify their passion and test the charged ground between them. Recklessly, the two verge toward the one thing both fear they may never truly find again: total intimacy. It is an instant classic and one of the great love stories of our time.
                                              
                                            
                                              
                                            ')
INSERT [dbo].[Book] ([bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate], [categoryID], [bookAuthor], [bookDescription]) VALUES (12, N'Disney Gravity Falls : Journal 3 (Hardcover)', N'active', N'assets/img/0620fbb96a7e739503a6dcc2ca9edb8e.jpg', 17, 4, CAST(N'2021-06-27 16:18:16.467' AS DateTime), N'CB', N' Alex Hirsch, Rob Renzetti', N'Journal 3 brims with every page ever seen on the show plus all-new pages with monsters and secrets, notes from Dipper and Mabel, and the Author''s full story. Fans of Gravity Falls will simply love this 288-page full-color jacketed hardcover version of Journal 3! Plus the book jacket doubles as an exclusive poster!')
INSERT [dbo].[Book] ([bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate], [categoryID], [bookAuthor], [bookDescription]) VALUES (13, N'The Fault In Our Stars', N'active', N'assets/img/the-fault-in-our-stars.jpg', 13, 20, CAST(N'2021-06-26 00:00:00.000' AS DateTime), N'NO', N'Jeff Kinney', N'A striking black edition of the multi-million #1 bestseller, now a major motion picture starring Shailene Woodley and Ansel Elgort.

"I fell in love the way you fall asleep: slowly, then all at once."

Despite the tumor-shrinking medical miracle that has bought her a few years, Hazel has never been anything but terminal, her final chapter inscribed upon diagnosis. But when a gorgeous plot twist named Augustus Waters suddenly appears at Cancer Kid Support Group, Hazel''s story is about to be completely rewritten.
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            
                                              
                                            ')
INSERT [dbo].[Book] ([bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate], [categoryID], [bookAuthor], [bookDescription]) VALUES (14, N'Educated : A Memoir', N'inactive', N'assets/img/bb4d3ad681e45ce011aeef7241df34ee.jpg', 18, 15, CAST(N'2021-06-27 16:23:47.433' AS DateTime), N'AL', N'J. K. Rowling', N'Born to survivalists in the mountains of Idaho, Tara Westover was seventeen the first time she set foot in a classroom. Her family was so isolated from mainstream society that there was no one to ensure the children received an education, and no one to intervene when one of Tara''s older brothers became violent. When another brother got himself into college, Tara decided to try a new kind of life. Her quest for knowledge transformed her, taking her over oceans and across continents, to Harvard and to Cambridge University. Only then would she wonder if she''d traveled too far, if there was still a way home.')
INSERT [dbo].[Book] ([bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate], [categoryID], [bookAuthor], [bookDescription]) VALUES (16, N'test', N'active', N'assets/img/harry potter.jpg', 20, 0, CAST(N'2021-07-05 00:00:00.000' AS DateTime), N'CB', N'J. K. Rowling', N'tesst
                                              
                                            ')
INSERT [dbo].[Book] ([bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate], [categoryID], [bookAuthor], [bookDescription]) VALUES (17, N'test 2', N'active', N'assets/img/harry potter.jpg', 20, 1000, CAST(N'2021-07-08 00:00:00.000' AS DateTime), N'AL', N'test', N'test
                                              
                                            
                                              
                                            ')
INSERT [dbo].[Book] ([bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate], [categoryID], [bookAuthor], [bookDescription]) VALUES (18, N'test 3', N'active', N'assets/img/harry potter.jpg', 19, 10, CAST(N'2021-07-08 13:52:04.740' AS DateTime), N'AL', N'test', N'test')
INSERT [dbo].[Book] ([bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate], [categoryID], [bookAuthor], [bookDescription]) VALUES (19, N'test_book', N'active', N'assets/img/98fbb7ffdcccb5d6679b9818e8a27e6b.jpg', 10, 1000, CAST(N'2021-07-13 07:22:18.223' AS DateTime), N'AL', N'Jeff Kinney', N'test')
SET IDENTITY_INSERT [dbo].[Book] OFF
INSERT [dbo].[Category] ([categoryID], [categoryName], [categoryStatus]) VALUES (N'AL', N'Arts and Literature', N'active')
INSERT [dbo].[Category] ([categoryID], [categoryName], [categoryStatus]) VALUES (N'CB', N'Children''s books', NULL)
INSERT [dbo].[Category] ([categoryID], [categoryName], [categoryStatus]) VALUES (N'NO', N'Novel', NULL)
INSERT [dbo].[Discount] ([discountID], [discountName], [discountPercent], [discountStatus], [createDate], [userID]) VALUES (N'KM20', N'20% off', 20, N'active', CAST(N'2021-07-04 15:45:57.540' AS DateTime), N'user2')
INSERT [dbo].[Discount] ([discountID], [discountName], [discountPercent], [discountStatus], [createDate], [userID]) VALUES (N'KM50', N'50% off', 50, N'active', CAST(N'2021-06-26 00:00:00.000' AS DateTime), N'user')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'16253029301293599307', N'user', CAST(N'2021-07-03 16:02:10.130' AS DateTime), N'Finish', N'290A', N'0353270383', 23.5, N'KM50', N'Payment on delivery')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'16253046390913599307', N'user', CAST(N'2021-07-03 16:30:39.090' AS DateTime), N'Finish', N'290A', N'0353270383', 16, NULL, N'Payment on delivery')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'16253047094693599307', N'user', CAST(N'2021-07-03 16:31:49.470' AS DateTime), N'Finish', N'290A', N'0353270383', 145, NULL, N'Payment on delivery')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'16253059026293599307', N'user', CAST(N'2021-07-03 16:51:42.627' AS DateTime), N'Finish', N'290A', N'0353270383', 9, N'KM50', N'Payment on delivery')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625385175409111578567', N'user2', CAST(N'2021-07-04 14:52:55.403' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 20, NULL, N'Payment on delivery')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625387518243111578567', N'user2', CAST(N'2021-07-04 15:31:58.243' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 36, NULL, N'Online Payment')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625391230210111578567', N'user2', CAST(N'2021-07-04 16:33:50.210' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 17, N'KM20', N'Online Payment')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625410297254111578567', N'user2', CAST(N'2021-07-04 21:51:37.250' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 58, NULL, N'Online Payment')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625470219982111578567', N'user2', CAST(N'2021-07-05 14:30:19.977' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 207.39999389648438, N'KM20', N'Online Payment')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625471335766111578567', N'user2', CAST(N'2021-07-05 14:48:55.767' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 84, NULL, N'Online Payment')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625471354742111578567', N'user2', CAST(N'2021-07-05 14:49:14.743' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 185, NULL, N'Payment on delivery')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625727419173111578567', N'user2', CAST(N'2021-07-08 13:56:59.173' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 197, N'KM20', N'Online Payment')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625898353078111578567', N'user2', CAST(N'2021-07-10 13:25:53.070' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 37, NULL, N'Payment on delivery')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'16258984695193599307', N'user', CAST(N'2021-07-10 13:27:49.520' AS DateTime), N'Finish', N'Quận 9, TP HCM', N'0353270383', 54, NULL, N'Payment on delivery')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625898768895111578567', N'user2', CAST(N'2021-07-10 13:32:48.897' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 245, NULL, N'Online Payment')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1625899891060111578567', N'user2', CAST(N'2021-07-10 13:51:31.060' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 330, NULL, N'Online Payment')
INSERT [dbo].[Order] ([orderID], [userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType]) VALUES (N'1626135619618111578567', N'user2', CAST(N'2021-07-13 07:20:19.597' AS DateTime), N'Finish', N'Quận 7, TP HCM', N'0353270383', 48, NULL, N'Online Payment')
SET IDENTITY_INSERT [dbo].[OrderDetail] ON 

INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (6, 9, 2, N'16253029301293599307')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (7, 10, 1, N'16253029301293599307')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (8, 9, 1, N'16253046390913599307')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (9, 9, 1, N'16253047094693599307')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (10, 13, 3, N'16253047094693599307')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (11, 14, 5, N'16253047094693599307')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (14, 14, 1, N'16253059026293599307')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (15, 10, 1, N'1625385175409111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (16, 9, 1, N'1625387518243111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (17, 10, 1, N'1625387518243111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (18, 10, 1, N'1625391230210111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (19, 8, 2, N'1625410297254111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (20, 13, 1, N'1625410297254111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (21, 14, 1, N'1625410297254111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (22, 8, 23, N'1625470219982111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (23, 9, 4, N'1625471335766111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (24, 10, 1, N'1625471335766111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (25, 10, 12, N'1625471354742111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (26, 17, 12, N'1625727419173111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (27, 10, 1, N'1625898353078111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (28, 12, 1, N'1625898353078111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (29, 10, 1, N'16258984695193599307')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (30, 12, 2, N'16258984695193599307')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (31, 17, 12, N'1625898768895111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (32, 8, 11, N'1625899891060111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (33, 12, 12, N'1625899891060111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (34, 8, 1, N'1626135619618111578567')
INSERT [dbo].[OrderDetail] ([orderDetailID], [bookID], [amount], [orderID]) VALUES (35, 9, 2, N'1626135619618111578567')
SET IDENTITY_INSERT [dbo].[OrderDetail] OFF
INSERT [dbo].[Role] ([roleID], [roleName], [roleStatus]) VALUES (N'AD', N'Admin', N'active')
INSERT [dbo].[Role] ([roleID], [roleName], [roleStatus]) VALUES (N'US', N'User', N'active')
INSERT [dbo].[User] ([userID], [password], [userName], [userPhone], [userEmail], [roleID], [userStatus], [userCreateDate], [userAddress]) VALUES (N'admin', N'123', N'admin', N'0353270383', N'admin@gmail.com', N'AD', N'active', CAST(N'2021-06-23 00:00:00.000' AS DateTime), N'TP HCM')
INSERT [dbo].[User] ([userID], [password], [userName], [userPhone], [userEmail], [roleID], [userStatus], [userCreateDate], [userAddress]) VALUES (N'user', N'123', N'user', N'0353270383', N'user@gmail.com', N'US', N'active', CAST(N'2021-06-23 00:00:00.000' AS DateTime), N'Quận 9, TP HCM')
INSERT [dbo].[User] ([userID], [password], [userName], [userPhone], [userEmail], [roleID], [userStatus], [userCreateDate], [userAddress]) VALUES (N'user2', N'123', N'user2', N'0353270383', N'user2@gmail.com', N'US', N'active', CAST(N'2021-06-23 00:00:00.000' AS DateTime), N'Quận 7, TP HCM')
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [FK_Books_Category] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Category] ([categoryID])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [FK_Books_Category]
GO
ALTER TABLE [dbo].[Discount]  WITH CHECK ADD  CONSTRAINT [FK_Discount_User] FOREIGN KEY([userID])
REFERENCES [dbo].[User] ([userID])
GO
ALTER TABLE [dbo].[Discount] CHECK CONSTRAINT [FK_Discount_User]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Discount] FOREIGN KEY([discountID])
REFERENCES [dbo].[Discount] ([discountID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Discount]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Books] FOREIGN KEY([bookID])
REFERENCES [dbo].[Book] ([bookID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Books]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Order] FOREIGN KEY([orderID])
REFERENCES [dbo].[Order] ([orderID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Order]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Role] FOREIGN KEY([roleID])
REFERENCES [dbo].[Role] ([roleID])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Role]
GO
USE [master]
GO
ALTER DATABASE [BookStoreOnline] SET  READ_WRITE 
GO
