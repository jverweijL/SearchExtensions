# PageOnlyQueryPreFilterContributor

For a customer with a page-centric intranet I created this module as an example. For non-administrator users they only wanted to return pages
in the search result. 

Developed to run on the following versions of Liferay: `Liferay DXP 7.3`

Built with [Liferay Workspace](https://help.liferay.com/hc/en-us/articles/360029147471-Liferay-Workspace) and [Blade CLI](https://help.liferay.com/hc/en-us/articles/360029147071-Blade-CLI).

*As you can see in the image below only pages are returned*

![screenshot](img.png)

## How to Build and Deploy to Liferay

Follow the steps below to build and deploy or copy the modules from the [releases](../../releases/latest) page to your Liferay's deploy folder.

In order to build or deploy this module you will need to [install Blade CLI](https://help.liferay.com/hc/en-us/articles/360028833852-Installing-Blade-CLI).

### To Build

`$ blade gw build`

You can find the built modules at `https://github.com/jverweijL/SearchExtensions/releases/download/v0.1/com.liferay.demo.search.pageonlyqueryprefiltercontributor-1.0.0.jar`.

### To Deploy

In `gradle-local.properties` add the following line to point towards the Liferay instance you want to deploy to:
```
liferay.workspace.home.dir=/path/to/liferay/home
```

`$ blade gw deploy`

## Usage

Once you have deployed the module non-administrator users should only find pages.

### Features

* implementation of QueryPreFilterContributor


## Issues & Questions Welcome