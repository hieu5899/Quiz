/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hieu Mau
 * Created: May 24, 2021
 */

CREATE DATABASE [OnlineQuizLab]
GO
USE [OnlineQuizLab]
GO
/****** Object:  Table [dbo].[Answers]    Script Date: 5/18/2021 9:18:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Answers](
	[questionCode] [int] NOT NULL,
	[optionCode] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[questionCode] ASC,
	[optionCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Options]    Script Date: 5/18/2021 9:18:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Options](
	[questionCode] [int] NOT NULL,
	[optionCode] [int] NOT NULL,
	[optionContent] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[questionCode] ASC,
	[optionCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Questions]    Script Date: 5/18/2021 9:18:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Questions](
	[questionCode] [int] IDENTITY(1,1) NOT NULL,
	[questionContent] [nvarchar](255) NOT NULL,
	[createdAt] [date] NULL,
	[username] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[questionCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Result]    Script Date: 5/18/2021 9:18:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Result](
	[resultCode] [int] IDENTITY(1,1) NOT NULL,
	[userName] [varchar](50) NULL,
	[score] [float] NULL,
	[submitTime] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[resultCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Users]    Script Date: 5/18/2021 9:18:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[role] [int] NOT NULL,
	[email] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Answers] ([questionCode], [optionCode]) VALUES (1, 1)
INSERT [dbo].[Answers] ([questionCode], [optionCode]) VALUES (2, 2)
INSERT [dbo].[Answers] ([questionCode], [optionCode]) VALUES (3, 3)
INSERT [dbo].[Answers] ([questionCode], [optionCode]) VALUES (4, 1)
INSERT [dbo].[Answers] ([questionCode], [optionCode]) VALUES (5, 2)
INSERT [dbo].[Answers] ([questionCode], [optionCode]) VALUES (6, 1)
INSERT [dbo].[Answers] ([questionCode], [optionCode]) VALUES (7, 1)
INSERT [dbo].[Answers] ([questionCode], [optionCode]) VALUES (8, 2)
INSERT [dbo].[Answers] ([questionCode], [optionCode]) VALUES (9, 1)
INSERT [dbo].[Answers] ([questionCode], [optionCode]) VALUES (10, 3)
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (1, 1, N'1-A')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (1, 2, N'1-B')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (1, 3, N'1-C')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (2, 1, N'2-A')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (2, 2, N'2-B')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (3, 1, N'3-A')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (3, 2, N'3-B')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (3, 3, N'3-C')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (3, 4, N'3-D')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (4, 1, N'4-A')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (4, 2, N'4-B')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (5, 1, N'5-A')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (5, 2, N'5-B')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (5, 3, N'5-C')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (5, 4, N'5-D')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (6, 1, N'6-A')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (6, 2, N'6-B')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (7, 1, N'7-A')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (7, 2, N'7-B')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (7, 3, N'7-C')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (8, 1, N'8-A')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (8, 2, N'8-B')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (8, 3, N'8-C')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (9, 1, N'9-A')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (9, 2, N'9-B')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (9, 3, N'9-C')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (10, 1, N'12')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (10, 2, N'23')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (10, 3, N'34')
INSERT [dbo].[Options] ([questionCode], [optionCode], [optionContent]) VALUES (10, 4, N'45')
SET IDENTITY_INSERT [dbo].[Questions] ON 

INSERT [dbo].[Questions] ([questionCode], [questionContent], [createdAt], [username]) VALUES (1, N'Cau hoi 1', CAST(0x90400B00 AS Date), N'teacher')
INSERT [dbo].[Questions] ([questionCode], [questionContent], [createdAt], [username]) VALUES (2, N'Cau hoi 2', CAST(0xB1400B00 AS Date), N'teacher')
INSERT [dbo].[Questions] ([questionCode], [questionContent], [createdAt], [username]) VALUES (3, N'Cau hoi 3', CAST(0xCE400B00 AS Date), N'teacher')
INSERT [dbo].[Questions] ([questionCode], [questionContent], [createdAt], [username]) VALUES (4, N'Cau hoi 4', CAST(0x12410B00 AS Date), N'teacher')
INSERT [dbo].[Questions] ([questionCode], [questionContent], [createdAt], [username]) VALUES (5, N'Cau hoi 5', CAST(0x9A330B00 AS Date), N'teacher')
INSERT [dbo].[Questions] ([questionCode], [questionContent], [createdAt], [username]) VALUES (6, N'Cau hoi 6', CAST(0xEF400B00 AS Date), N'teacher')
INSERT [dbo].[Questions] ([questionCode], [questionContent], [createdAt], [username]) VALUES (7, N'Cau hoi 7', CAST(0x07420B00 AS Date), N'teacher')
INSERT [dbo].[Questions] ([questionCode], [questionContent], [createdAt], [username]) VALUES (8, N'Cau hoi 8', CAST(0x07420B00 AS Date), N'hieu')
INSERT [dbo].[Questions] ([questionCode], [questionContent], [createdAt], [username]) VALUES (9, N'Cau hoi 9', CAST(0x07420B00 AS Date), N'hieu')
INSERT [dbo].[Questions] ([questionCode], [questionContent], [createdAt], [username]) VALUES (10, N'têchrrrr', CAST(0x33420B00 AS Date), N'teacher')
SET IDENTITY_INSERT [dbo].[Questions] OFF
INSERT [dbo].[Users] ([username], [password], [role], [email]) VALUES (N'student', N'123', 0, N'student@email.com')
INSERT [dbo].[Users] ([username], [password], [role], [email]) VALUES (N'teacher', N'123', 1, N'teacher@email.com')
INSERT [dbo].[Users] ([username], [password], [role], [email]) VALUES (N'hieu', N'123', 1, N'hieu@gmail.com')
ALTER TABLE [dbo].[Questions] ADD  DEFAULT (getdate()) FOR [createdAt]
GO
ALTER TABLE [dbo].[Result] ADD  DEFAULT (getdate()) FOR [submitTime]
GO
ALTER TABLE [dbo].[Answers]  WITH CHECK ADD FOREIGN KEY([questionCode])
REFERENCES [dbo].[Questions] ([questionCode])
GO
ALTER TABLE [dbo].[Answers]  WITH CHECK ADD FOREIGN KEY([questionCode])
REFERENCES [dbo].[Questions] ([questionCode])
GO
ALTER TABLE [dbo].[Answers]  WITH CHECK ADD FOREIGN KEY([questionCode])
REFERENCES [dbo].[Questions] ([questionCode])
GO
ALTER TABLE [dbo].[Options]  WITH CHECK ADD FOREIGN KEY([questionCode])
REFERENCES [dbo].[Questions] ([questionCode])
GO
ALTER TABLE [dbo].[Options]  WITH CHECK ADD FOREIGN KEY([questionCode])
REFERENCES [dbo].[Questions] ([questionCode])
GO
ALTER TABLE [dbo].[Options]  WITH CHECK ADD FOREIGN KEY([questionCode])
REFERENCES [dbo].[Questions] ([questionCode])
GO
ALTER TABLE [dbo].[Questions]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Users] ([username])
GO
ALTER TABLE [dbo].[Result]  WITH CHECK ADD FOREIGN KEY([userName])
REFERENCES [dbo].[Users] ([username])
GO
ALTER TABLE [dbo].[Result]  WITH CHECK ADD FOREIGN KEY([userName])
REFERENCES [dbo].[Users] ([username])
GO