import React from 'react'
import AddUser from '../users/AddUser'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './Home'
import EditUser from '../users/EditUser'
import ViewUser from '../users/ViewUser'

export default function Dashboard() {
    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route exact path='/' element={<Home/>} />
                    <Route exact path='/adduser' element={<AddUser />} />
                    <Route exact path="/edituser/:id" element={<EditUser/>}/>
                    <Route exact path="/viewuser/:id" element={<ViewUser/>}/> 

                </Routes>
            </BrowserRouter>
        </div>
    )
}
