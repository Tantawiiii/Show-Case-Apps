import 'package:flutter/material.dart';
import 'package:showcaseview/showcaseview.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final GlobalKey add = GlobalKey();
  final GlobalKey image = GlobalKey();
  final GlobalKey search = GlobalKey();
  final GlobalKey menu = GlobalKey();

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addPostFrameCallback((timeStamp) {
      ShowCaseWidget.of(context).startShowCase([add, image, search, menu]);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        toolbarHeight: 90,
        title: const Text(
          "Show Case In Flutter",
          style: TextStyle(
            color: Colors.white,
            fontWeight: FontWeight.bold,
            fontSize: 18,
          ),
        ),
        centerTitle: true,
        backgroundColor: Colors.indigoAccent,
        elevation: 15,
        leading: IconButton(
          onPressed: () {},
          icon: Showcase(
            key: menu,
            description: 'Tap to open Navigation Menu',
            overlayOpacity: 0.5,
            targetShapeBorder: const CircleBorder(),
            targetPadding: const EdgeInsets.all(8),
            child: const Icon(
              Icons.menu,
              color: Colors.white,
              size: 26,
            ),
          ),
        ),
        actions: [
          IconButton(
            onPressed: () {},
            icon: Showcase(
              key: search,
              description: 'Tap to Start Searching',
              overlayOpacity: 0.5,
              targetShapeBorder: const CircleBorder(),
              targetPadding: const EdgeInsets.all(8),
              child: const Icon(
                Icons.search,
                color: Colors.white,
                size: 24,
              ),
            ),
          ),
        ],
      ),
      floatingActionButton: Showcase(
        key: add,
        description: "Click to add a new Item ",
        overlayOpacity: 0.5,
        targetShapeBorder: const CircleBorder(),
        child: FloatingActionButton(
          onPressed: () {},
          backgroundColor: Colors.indigoAccent,
          child: const Icon(
            Icons.add,
            color: Colors.white,
          ),
        ),
      ),
      body: Center(
        child: Column(
          children: <Widget>[

            const SizedBox(height: 100,),

            Showcase(
              key: image,
              description: "Click to change your avatar",
              overlayOpacity: 0.5,
              child: Image.asset(
                "assets/woman_white.png",
              ),
            ),
            const SizedBox(height: 24,),
            const Text(
              "@Tantawiii",
              style: TextStyle(
                color: Colors.indigoAccent,
                fontWeight: FontWeight.bold,
                fontSize: 18,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
