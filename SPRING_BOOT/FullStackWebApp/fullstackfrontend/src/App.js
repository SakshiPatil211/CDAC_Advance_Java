import logo from './logo.svg';
import './App.css';
import MyHeader from './component/MyHeader';
import MyFooter from './component/MyFooter';
import { Routes,Route } from 'react-router-dom';
import NavBar from './component/NavBar';
function App() {
  return (
    <div>
      <MyHeader/>
      <NavBar></NavBar>
      <Routes>
         <Route path="/" element={<Navigate replace to="/home"></Navigate>}></Route>

         <Route path="/home" element={<HomeComponent></HomeComponent>}></Route>
         <Route path="/table" element={<ProductTable></ProductTable>}>
             <Route path="details/:pid" element={<ProductDetails></ProductDetails>}></Route>
         
         </Route>
         <Route path="/edit/:pid" element={<ProductEdit></ProductEdit>}></Route>

         <Route path="/form" element={<ProductForm></ProductForm>}></Route>

         <Route path="/aboutus" element={<AboutUs></AboutUs>}></Route>
      </Routes>
      <MyFooter/>
    </div>
  );
}

export default App;
