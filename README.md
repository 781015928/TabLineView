viewpager = (ViewPager)findViewById(R.id.viewpager);
tabLineView = (TabLineView)findViewById(R.id.tablineview);
viewpager.setAdapter(new TestPageAdapter());
tabLineView.setupWithViewPager(viewpager);


   compile 'com.czgfor.lxy:tablineview:1.0'