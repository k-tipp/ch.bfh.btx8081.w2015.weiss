USE [SWE_White]
GO
ALTER TABLE [dbo].[MEDICATION] DROP CONSTRAINT [MDCATIONPTENTPATIENTID]
GO
ALTER TABLE [dbo].[APPOINTMENT] DROP CONSTRAINT [PPNTMENTPTENTPATIENTID]
GO
/****** Object:  Table [dbo].[SEQUENCE]    Script Date: 10.12.2015 13:07:16 ******/
DROP TABLE [dbo].[SEQUENCE]
GO

DROP TABLE [dbo].[SOAP]
GO

/****** Object:  Table [dbo].[PATIENT]    Script Date: 10.12.2015 13:07:16 ******/
DROP TABLE [dbo].[PATIENT]
GO
/****** Object:  Table [dbo].[MEDICATION]    Script Date: 10.12.2015 13:07:17 ******/
DROP TABLE [dbo].[MEDICATION]
GO
/****** Object:  Table [dbo].[APPOINTMENT]    Script Date: 10.12.2015 13:07:17 ******/
DROP TABLE [dbo].[APPOINTMENT]
GO

DROP TABLE [dbo].[DANGERTOOTHERS]
GO

DROP TABLE [dbo].[DRUG]
GO

DROP TABLE [dbo].[SELFHARM]
GO

DROP TABLE [dbo].[MEDICALUSER]
GO