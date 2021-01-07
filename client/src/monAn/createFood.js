import React, { useEffect, useState } from "react";
import {
  CButton,
  CModal,
  CModalHeader,
  CModalBody,
  CModalFooter,
  CContainer,
  CRow,
  CCol,
  CImg,
} from "@coreui/react";
import { createOneMonAn } from '../api/MonAnApi';
import alertify from "alertifyjs";
import { getAllLoaiMonAn } from '../api/LoaiMonAnApi';

const CreateFood = (props) => {

  useEffect(() => {
    getAllLoaiMonAn().then(result => {
      setFoodTypes(result);
      if (result.length > 0) {
        setFoodTypesId(result.find(() => true));
      }
    });
  }, []);

  const [dvt, setDvt] = useState();
  const [giaban, setGiaBan] = useState();
  const [giavon, setGiaVon] = useState();
  const [motachitiet, setMoTaChiTiet] = useState();
  const [ten, setTen] = useState();
  const [hinhanh, setHinhAnh] = useState();
  const [foodTypesId, setFoodTypesId] = useState();
  const [foodTypes, setFoodTypes] = useState([]);

  const onSubmit = async (e) => {
    e.preventDefault();
    // const data = {
    //   dvt, giaban, giavon, motachitiet, ten, hinhanh
    // }

    const formData = new FormData();

    formData.append('ma_ten', ten);
    formData.append('ma_giavon', giavon);
    formData.append('ma_giaban', giaban);
    formData.append('ma_donvitinh', dvt);
    formData.append('ma_motachitiet', motachitiet);
    formData.append('image', hinhanh);

    try {
      await createOneMonAn(formData);
      props.toggleModal();
      props.createSuccess();
      alertify.success("Thêm món ăn thành công");
    } catch (err) {
      alertify.error("Lỗi nghen");
    }
  }

  return (
    <div className='create-food'>
      <CModal show={props.modal} onClose={props.toggleModal} size="md">
        <CModalHeader closeButton>
          <h3>Thêm mới món sản phẩm</h3>
        </CModalHeader>
        <form onSubmit={onSubmit}>
          <CModalBody className="create-food-content">
            <CRow className="field">
              <CCol lg="10">
                <CRow>
                  <CCol lg="5" className="pt-2">
                    Tên món ăn
                    </CCol>
                  <CCol>
                    <input
                      type="text"
                      placeholder="Nhập tên thức ăn"
                      className="form-control"
                      onChange={(e) => {
                        setTen(e.target.value);
                      }}
                      style={{ width: "100%" }}
                      required
                    />
                  </CCol>
                </CRow>
              </CCol>
            </CRow>
            <CRow className="field">
              <CCol lg="10">
                <CRow>
                  <CCol lg="5" className="pt-2">
                    Giá vốn
                    </CCol>
                  <CCol>
                    <input
                      type="text"
                      placeholder="Nhập giá vốn"
                      className="form-control"
                      onChange={(e) => {
                        setGiaVon(e.target.value);
                      }}
                      style={{ width: "100%" }}
                      required
                    />
                  </CCol>
                </CRow>
              </CCol>
            </CRow>
            <CRow className="field">
              <CCol lg="10">
                <CRow>
                  <CCol lg="5" className="pt-2">
                    Giá bán
                    </CCol>
                  <CCol>
                    <input
                      type="text"
                      placeholder="Nhập giá bán"
                      className="form-control"
                      onChange={(e) => {
                        setGiaBan(e.target.value);
                      }}
                      style={{ width: "100%" }}
                      required
                    />
                  </CCol>
                </CRow>
              </CCol>
            </CRow>
            <CRow className="field">
              <CCol lg="10">
                <CRow>
                  <CCol lg="5" className="pt-2">
                    Đơn vị tính
                    </CCol>
                  <CCol>
                    <input
                      type="text"
                      placeholder="Nhập đơn vị tính"
                      className="form-control"
                      onChange={(e) => {
                        setDvt(e.target.value);
                      }}
                      style={{ width: "100%" }}
                      required
                    />
                  </CCol>
                </CRow>
              </CCol>
            </CRow>
            <CRow className="field">
              <CCol lg="10">
                <CRow>
                  <CCol lg="5" className="pt-2">
                    Mô tả chi tiết
                    </CCol>
                  <CCol>
                    <input
                      type="text"
                      placeholder="Mô tả chi tiết món ăn"
                      className="form-control"
                      onChange={(e) => {
                        setMoTaChiTiet(e.target.value);
                      }}
                      style={{ width: "100%" }}
                    />
                  </CCol>
                </CRow>
              </CCol>
            </CRow>
            <CRow className="field">
              <CCol lg="10">
                <CRow>
                  <CCol lg="5" className="pt-2">
                    Loại món ăn
                    </CCol>
                  <CCol>
                    <select className="form-control"
                      value={foodTypesId}
                      onChange={e => setFoodTypesId(e.target.value)}>
                      {foodTypes.map((foodType, index) => (
                        <option key={index} value={foodType.lma_id}>{foodType.lma_ten}</option>
                      ))}
                    </select>
                  </CCol>
                </CRow>
              </CCol>
            </CRow>
            <CRow className="field">
              <CCol className="pt-3">
                <input type="file" onChange={(e) => {
                  e.preventDefault();

                  const image = e.target.files[0];

                  setHinhAnh(image);
                }} />
              </CCol>
            </CRow>
            <CRow className="field">
              <CCol className="pt-3">
                {hinhanh && <img className="c-avatar-img" src={URL.createObjectURL(hinhanh)} alt="avatar-pic" />}
              </CCol>
            </CRow>
          </CModalBody>
          <CModalFooter>
            <CButton color="primary" type="submit">
              Thêm mới
            </CButton>
            <CButton color="secondary" onClick={props.toggleModal}>
              Bỏ qua
            </CButton>
          </CModalFooter>
        </form>
      </CModal>
    </div>
  );
};

export default CreateFood;
